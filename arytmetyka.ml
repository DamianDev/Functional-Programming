(* za zbiór pusty uznaję (nan, nan, _) : wartosc *)

type wartosc = float*float*bool;;


let wartosc_dokladnosc x p = (((min (x -. (x *. p /. 100.)) (x +. x *. p /. 100.)), (max (x -. (x *. p /. 100.)) (x +. x *. p /. 100.)), true) : wartosc);;


let wartosc_dokladna x = ((x, x, true) : wartosc);;


let wartosc_od_do x y = ((x , y, true) : wartosc);;


let in_wartosc ((a, b, c) : wartosc) y =
	if c = true then (y >= a && y <= b)
	else y <= a || y >= b;;
	
	
let min_wartosc  ((x, y, z) : wartosc) = 
	if z = true then
		if x = nan then nan
		else x
	else 
		if x = infinity then infinity
		else if x = nan then nan
		else neg_infinity;;
	
	
let max_wartosc ((x, y, z) : wartosc) =
	if z = true then
		if y = nan then nan
		else y
	else 
		if y = neg_infinity then neg_infinity
		else if y = nan then nan
		else infinity;;

		
let sr_wartosc ((x, y, z) : wartosc) = 
	if z = true then
		if max_wartosc (x, y, true) = infinity || min_wartosc (x, y, true) = neg_infinity then nan
		else ((max_wartosc (x, y, true) +. min_wartosc (x, y, true)) /. 2.0)
	else nan;;

	
let plus ((a, b, c) : wartosc)((x, y, z) : wartosc) = 
	if c = true then
		if z = true then
			if (a = nan && b = nan) && (x <> nan && y <> nan) then ((x, y, true) : wartosc)
			else if (x = nan && y = nan) && (a <> nan && b <> nan) then ((a, b, true) : wartosc)
			else ((a +. x , b +. y, true) : wartosc)
		else
			if (a = nan && b = nan) && (x <> nan && y <> nan) then ((x, y, false) : wartosc)
			else if (x = nan && y = nan) && (a <> nan && b <> nan) then ((a, b, true) : wartosc)
			else ((a +. x , b +. y, false) : wartosc)
	else
		if z = true then
				if (a = nan && b = nan) && (x <> nan && y <> nan) then ((x, y, true) : wartosc)
				else if (x = nan && y = nan) && (a <> nan && b <> nan) then ((a, b, false) : wartosc)
				else ((a +. x , b +. y, true) : wartosc)
		else 
			if (a = nan && b = nan) && (x <> nan && y <> nan) then ((x, y, false) : wartosc)
			else if (x = nan && y = nan) && (a <> nan && b <> nan) then ((a, b, false) : wartosc)
			else ((neg_infinity , infinity, true) : wartosc);;

	
let minus ((a, b, c) : wartosc)((x, y, z) : wartosc) = plus ((a, b ,c) : wartosc) (((-.x), (-.y), z) : wartosc);;


let razy ((a,b,c) : wartosc) ((x,y,z) : wartosc) = 
	let min_w = min (min(a *. x) (a *. y)) (min (b *. x) (b *. y)) in
	let max_w = max (max(a *. x) (a *. y)) (max (b *. x) (b *. y)) in
	if (a = nan && b = nan) || (x = nan && y = nan) then ((nan, nan, true) : wartosc)
	else if c = true && z = true then ((min_w, max_w, true) : wartosc)
	else ((min_w, max_w, false) : wartosc);;
	
		
let podzielic ((a, b, c) : wartosc)((x, y, z) : wartosc) = 
	if x = 0. && y = 0. then ((nan,nan,true) : wartosc)
	else if (a = nan && b = nan) || (x = nan && y = nan) then ((nan, nan, true) : wartosc)
	else 
		let min_w = min (min(a /. x) (a /. y)) (min (b /. x) (b /. y)) in
		let max_w = max (max(a /. x) (a /. y)) (max (b /. x) (b /. y)) in
		if in_wartosc ((x, y, z) : wartosc) 0. then ((min_w, max_w, false) : wartosc)
		else ((min_w, max_w, true) : wartosc);;
		
(*  #use "arytmetyka.ml";;  *)