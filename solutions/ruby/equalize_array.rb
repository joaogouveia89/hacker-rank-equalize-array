def equalize_array arr
	arr.sort!
	last_el = 0 # as the lower constraint is 1 we can set the first to 0
	bigger_count = 0
	current_count = 0

	arr.each.with_index do |el, idx|
		if idx == 0
			last_el = el 
			current_count = 1
			next
		end
		if el == last_el
			current_count = current_count + 1
			if (idx == arr.length - 1 && bigger_count < current_count)
				bigger_count = current_count	
			end
		else
			if bigger_count < current_count
				bigger_count = current_count			
			end
			last_el = el
			current_count = 1
		end
	end
	arr.length - bigger_count
end