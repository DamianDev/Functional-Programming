type 'a queue = Node of 'a * 'a queue * 'a queue * int | Leaf;;

exception Empty;;

let empty = Leaf;;

(* Compares prority of Nodes *)
let priority a b = 
  match (a, b) with
    | (Node(x, _, _, _), Node(y, _, _, _)) -> x <= y
    | (_, _) -> true;;		
		
(* Getting leftistness of a particular queue *)
let leftistness q =
  match q with 
    | Node(_, _, _, a) -> a
    | Leaf -> -1;;

(* Function that merges two queues *) 
let rec join a b = 
  if priority a b then 
    match (a, b) with
      | (Node(priority1, left1, right1, l1), Node(priority2, left2, right2, l2)) ->

          let temp = join right1 b in
          let pL = leftistness left1 in
          let pR = leftistness temp in
            
            if pL >= pR then (Node(priority1, left1, temp, pR+1))
            else Node(priority1, temp, left1, pL+1)

      | (Leaf, Node(_, _, _, _)) -> b
      | (Node(_, _, _, _), Leaf) -> a
      | (Leaf, Leaf) -> Leaf
  else
    join b a;;


(* Function that checks if queue is empty *)
let is_empty q = 
  match q with 
    | Leaf -> true
    | _ -> false;;

(* Function that adds element to the queue *)
let add v q = join (Node(v,Leaf,Leaf,0)) q;;

(* Function that deletes the element with the smallest priority *)
let delete_min q =
  match q with
    | Node(p, left, right, l) -> (p, join left right)
    | Leaf -> raise Empty;;

