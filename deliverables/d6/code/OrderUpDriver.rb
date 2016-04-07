require_relative "OrderUp"
require_relative "Order"

orders = []
ids = [1,2,3,4,5,6,7,8,9,10]
names = ["Christian","Lauren","Stephanie","Laura","David","Pamela","Robert","Christine","Charlotte","Marley"]

queue = OrderUp.new

puts "Creating orders..."
for i in 0..(names.length-1)
  order = Order.new(ids[i],names[i])
  orders.push(order)
  queue.create_order(order)
end
puts "Ids: " + queue.view_waitlist_orders
puts "People: " + queue.view_waitlist_people
puts "Size: " + queue.waitlist_size.to_s
puts "\n"

puts "Resetting the Queue!!!!"
queue.reset!
puts "Ids: " + queue.view_waitlist_orders
puts "People: " + queue.view_waitlist_people
puts "Size: " + queue.waitlist_size.to_s
puts "\n"

puts "Creating orders again..."
orders.each do |order|
  queue.create_order(order)
end
puts "Ids: " + queue.view_waitlist_orders
puts "People: " + queue.view_waitlist_people
puts "Size: " + queue.waitlist_size.to_s
puts "\n"

puts "Completing Christian's Order"
queue.complete_order
puts "Ids: " + queue.view_waitlist_orders
puts "People: " + queue.view_waitlist_people
puts "Size: " + queue.waitlist_size.to_s
puts "\n"

puts "Discarding Robert's Order and Marley's Order "
queue.discard_order(orders[9])
queue.discard_order(orders[6])
puts "Ids: " + queue.view_waitlist_orders
puts "People: " + queue.view_waitlist_people
puts "Size: " + queue.waitlist_size.to_s
puts "\n"

puts "Completing Lauren's Order and Stephanie's Order"
queue.complete_order
queue.complete_order
puts "Ids: " + queue.view_waitlist_orders
puts "People: " + queue.view_waitlist_people
puts "Size: " + queue.waitlist_size.to_s
puts "\n"

puts "Whose order will be served next???"
puts queue.view_next_order.get_name.to_s + "'s"
puts "\n"

puts "Pamela would like to know her position in line!"
puts queue.waitlist_position(orders[5]).to_s
puts "\n"

puts "Completing Laura's Order"
queue.complete_order
puts "Ids: " + queue.view_waitlist_orders
puts "People: " + queue.view_waitlist_people
puts "Size: " + queue.waitlist_size.to_s
puts "\n"

puts "Discarding David's Order"
queue.discard_order(orders[4])
puts "Ids: " + queue.view_waitlist_orders
puts "People: " + queue.view_waitlist_people
puts "Size: " + queue.waitlist_size.to_s
puts "\n"

puts "Whose order will be served next???"
puts queue.view_next_order.get_name.to_s + "'s"
puts "\n"

puts "Christine would like to know her position in line!"
puts queue.waitlist_position(orders[7]).to_s
puts "\n"

puts "Completing Pamela's Order and Christine's Order"
queue.complete_order
queue.complete_order
puts "Ids: " + queue.view_waitlist_orders
puts "People: " + queue.view_waitlist_people
puts "Size: " + queue.waitlist_size.to_s
puts "\n"

puts "Discarding Charlotte's Order"
queue.discard_order(orders[8])
puts "Ids: " + queue.view_waitlist_orders
puts "People: " + queue.view_waitlist_people
puts "Size: " + queue.waitlist_size.to_s
puts "\n"
