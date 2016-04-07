require_relative "Queue"
require_relative "Order"

class OrderUp

  # Initializes the Order Queue
  def initialize
    @queue = Queue.new
  end

  # Add order to the end of the Queue
  def create_order(order)
    @queue.enqueue(order)
  end

  # Remove order from the beginning of the Queue
  def complete_order
    @queue.dequeue
  end

  # Remove order from the Queue (first occurence only)
  def discard_order(order)
    @queue.remove(order)
  end

  # View order at the beginning of the Queue
  def view_next_order
    @queue.peek
  end

  # Determine if order is at the beginning of the Queue
  def is_order_next?(order)
    @queue.peek == order
  end

  # View a string of all the orders in the Queue
  def view_waitlist
    @queue.to_str
  end

  # View a string of all the order ids in the Queue
  def view_waitlist_orders
    str = ""
    array = @queue.to_array
    array.each do |order|
      str += order.get_id.to_s + ","
    end
    str.chop
  end

  # View a string of all the order names in the Queue
  def view_waitlist_people
    str = ""
    array = @queue.to_array
    array.each do |order|
      str += order.get_name.to_s + ","
    end
    str.chop
  end

  # Determine position of order in the Queue
  def waitlist_position(order)
    @queue.position_of(order)
  end

  # Determine size of Queue
  def waitlist_size
    @queue.size
  end

  # Reset the Queue
  def reset!
    @queue.clear!
  end

end
