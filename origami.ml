type point = float * float;;

type kartka = point -> int;;

let prostokat ((x1, y1) : point) (x2, y2 : point) =
  ((fun (x, y) -> 
      if x >= x1 && x <= x2 && y >= y1 && y <= y2 then 1
      else 0) : kartka);;

let kolko ((x1, y1) : point) r = 
  ((fun (x,y) -> 
      if (x1 -. x) *. (x1 -. x) +. (y1-.y) *. (y1 -. y) <= r *. r then 1
      else 0 ) : kartka );;




(* Funkcje pomocnicze *)

(*
Korzystając z wasności iloczynu wektorowego sprawdzam czy punkt jest
"nad", "pod" czy na prostej:
0 - na prostej
<0 - nad prostą (z lewej)
>0 - pod prostą (z prawej)
*)
let iloczyn_wektorowy ((x1,y1) : point) ((x2, y2) : point) ((x,y) : point) =
  (x -. x1) *. (y2 -. y) -. (x2 -. x) *. (y -. y1);;


(* Zwraca obraz punktu w symetrii względem zadanej prostej *)
let punkt_symetryczny (x1,y1) (x2,y2) (x,y) =
  if x1 = x2 then (2. *. x1 -. x, y) (* Prosta prostopadła do osi X *)
  else if y1 = y2 then (x, 2. *. y1 -. y) (* Prosta równoległa do osi X *)
  else
    let a = (y2 -. y1) /. (x2 -. x1) in (* Współczynnik a prostej y = ax+b *)
    let b = y1 -. (x1 *. (y2 -. y1)) /. (x2 -. x1) in (* Współczynnik b prostej y = ax+b *)
    let d = (x +. (y -. b) *. a) /. (1. +. a *. a) in (* Wartość pomocnicza do obliczenia punktu symetrycznego *)
      (2. *. d -. x, 2. *. d *. a -. y +. 2. *. b);;

(* Koniec funkcji pomocniczych ;D *)




let zloz ((x1, y1) : point) ((x2, y2) : point) (k : kartka) = 
  if x1 = x2 && y1 = y2 then failwith "Punkty sa te same" (* Odrzucenie przyadku, że punkty są te same *)
  else
    (fun (x,y) -> 
       let dot = iloczyn_wektorowy (x1, y1) (x2, y2) (x,y) in (* Wartosc iloczynu wektorowego dla podanych danych *)
         if dot = 0. then k(x, y)
         else if dot < 0. then 
           k (x, y) + k (punkt_symetryczny (x1, y1) (x2,y2) (x, y))
         else 0
    );;


let skladaj l (k : kartka) = 
  List.fold_left (fun a (p1, p2) -> zloz p1 p2 a) k l;;
