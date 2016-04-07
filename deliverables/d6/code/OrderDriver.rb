require_relative "OrderUp"

puts "Creating Order for Christian"
order = Order.new(1,"Christian",["PB&J"])
puts order.to_str
puts "\n"

puts "Adding additional items to Christian's Order"
order.add_item("Crackers")
order.add_item("Juice")
puts order.to_str
puts "\n"

puts "Changing Id on Christian's Order"
order.set_id("123HEX456")
puts order.to_str
puts "\n"

puts "Changing the Items on Christian's Order"
order.set_items(["Oranges","Apples","Pears"])
puts order.to_str
puts "\n"

puts "Creating Order for Lauren"
order = Order.new(2,"Lauren",["Milk", "Cheese", "Tacos", "Grapes"])
puts order.to_str
puts "\n"

puts "Changing Name on Lauren's Order"
order.set_name("Crystal")
puts order.to_str
puts "\n"

puts "Removing some items from Crystal's Order"
order.delete_item("Tacos")
order.delete_item("Cheese")
puts order.to_str
puts "\n"
