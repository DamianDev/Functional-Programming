(* Code review'er: Wiktor Zanotto *)

#use "pMap.ml";;

exception Cykliczne;; (* Wyjątek rzucany gdy zależności są cykliczne *)

type visit = Visited | Visiting | Not_visited;;

(* Tworzy mapę z wartościami z listy *)
let map_values l = 
  let rec loop a k =
    match k with 
      | [] -> a
      | (x, y)::t -> loop (add x (ref Not_visited, y) a) t
  in loop empty l;;

(* Skopiowane z modułu List, tylko lekko zmodyfikowane aby iterowało po grafie *)
let rec graphIter f = function
    [] -> ()
  | (a, b)::l -> f a; graphIter f l;;

let topol graph = 
  let map = ref (map_values graph) in
  let acc = ref ([]) in
  let rec dfs value = 
    if exists value !map then 
      let (v, next) = find value !map in
        match !v with 
          | Visited -> ()
          | Visiting -> raise Cykliczne
          | Not_visited -> (

              v := Visiting;
              List.iter dfs next; (* Na każdym sąsiedzie wierzchołka wykonuje mojego dfs'a *)
              v := Visited;
              acc := value::(!acc);

            )
    else (

      map := add value (ref Visited, []) !map;
      acc := value::(!acc)

    )
  in
    graphIter dfs graph; !acc;;
