require 'spec_helper'

describe OrderUp do

  # *****************************************************************

  describe "#new" do

    context "when an OrderUp is created" do
      it "takes no parameters and returns an OrderUp object" do
        orders = OrderUp.new
        expect(orders).to be_an_instance_of OrderUp
      end
    end

  end

  # *****************************************************************

  describe "#create_order" do

    context "when an order is added to an empty queue" do
      it "increases the size of the queue from zero to one" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        expect(orders.waitlist_size).to equal 0
        orders.create_order(order)
        expect(orders.waitlist_size).to equal 1
      end
    end

    context "when an order is added to a queue with one order" do
      it "increases the size of the queue from one to two" do
        order1 = object_double(Order.new(1,"Christian",["A","B","C"]))
        order_2 = object_double(Order.new(2,"Lauren",["D","E","F"]))
        orders = OrderUp.new
        orders.create_order(order1)
        expect(orders.waitlist_size).to equal 1
        orders.create_order(order_2)
        expect(orders.waitlist_size).to equal 2
      end
    end

    context "when an order is added to a queue with multiple orders" do
      it "increases the size of the queue by one" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 1000
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Christian",["A","B","C"])))
        end
        expect(orders.waitlist_size).to equal range
        orders.create_order(order)
        expect(orders.waitlist_size).to equal range+1
      end
    end

  end

  # *****************************************************************

  describe "#complete_order" do

    context "when an order is completed on an empty queue" do
      it "causes the size of the queue to remain at zero" do
        orders = OrderUp.new
        expect(orders.waitlist_size).to equal 0
        orders.complete_order
        expect(orders.waitlist_size).to equal 0
      end
    end

    context "when an order is removed from a queue with one order" do
      it "decreases the size of the queue from one to zero" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        expect(orders.waitlist_size).to equal 1
        orders.complete_order
        expect(orders.waitlist_size).to equal 0
      end
    end

    context "when an order is removed from a queue with multiple orders" do
      it "decreases the size of the queue by one" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 1000
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Christian",["A","B","C"])))
        end
        expect(orders.waitlist_size).to equal range
        orders.complete_order
        expect(orders.waitlist_size).to equal range-1
      end
    end

  end

  # *****************************************************************

  describe "#discard_order" do

    context "attempt to discard an order in an empty queue" do
      it "does not remove the order and returns false" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        expect(orders.discard_order(order)).to be false
      end
    end

    context "attempt to discard an order in a queue with multiple orders discluding the requested order" do
      it "does not remove the order and returns false" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 100
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Lauren",["D","E","F"])))
        end
        expect(orders.discard_order(order)).to be false
      end
    end

    context "attempt to discard an order in a queue with multiple orders including the requested order" do
      it "removes the order and returns true" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 100
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Lauren",["D","E","F"])))
        end
        orders.create_order(order)
        expect(orders.discard_order(order)).to be true
      end
    end

    context "attempt to discard an order in a queue with multiple orders including duplicates of the requested order" do
      it "removes the first occurance of the order and returns true" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 100
        orders.create_order(order)
        orders.create_order(order)
        orders.create_order(order)
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Lauren",["D","E","F"])))
        end
        orders.create_order(order)
        size = orders.waitlist_size
        expect(orders.discard_order(order)).to be true
        expect(orders.waitlist_size). to equal size-1
      end
    end

    context "when the queue contains the requested order but it is popped" do
      it "does not remove the order and returns false" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        orders.complete_order
        expect(orders.discard_order(order)).to be false
      end
    end

    context "when the queue contains one order which is not the requested order" do
      it "does not remove the order and returns false" do
        order1 = object_double(Order.new(1,"Christian",["A","B","C"]))
        order_2 = object_double(Order.new(2,"Lauren",["D","E","F"]))
        orders = OrderUp.new
        orders.create_order(order_2)
        expect(orders.discard_order(order1)).to be false
      end
    end

    context "when the queue contains one order which is the requested order" do
      it "removes the order and returns true" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        expect(orders.discard_order(order)).to be true
      end
    end

  end

  # *****************************************************************

  describe "#view_next_order" do

    context "when an order is added to an empty queue" do
      it "returns the new order" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        expect(orders.view_next_order).to eql order
      end
    end

    context "when an order is added to a queue with an existing order" do
      it "returns first order" do
        order1 = object_double(Order.new(1,"Christian",["A","B","C"]))
        order_2 = object_double(Order.new(2,"Lauren",["D","E","F"]))
        orders = OrderUp.new
        orders.create_order(order1)
        orders.create_order(order_2)
        expect(orders.view_next_order).to eql order1
      end
    end

    context "when a node is added to a queue with multiple existing orders" do
      it "returns the first order" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        range = 100
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Lauren",["D","E","F"])))
        end
        expect(orders.view_next_order).to eql order
      end
    end

    context "when two orders are in the queue and the queue is popped" do
      it "returns the second order" do
        order1 = object_double(Order.new(1,"Christian",["A","B","C"]))
        order_2 = object_double(Order.new(2,"Lauren",["D","E","F"]))
        orders = OrderUp.new
        orders.create_order(order1)
        orders.create_order(order_2)
        orders.complete_order
        expect(orders.view_next_order).to eql order_2
      end
    end

    context "when one order is in the queue and the queue is popped" do
      it "returns nil" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        orders.complete_order
        expect(orders.view_next_order).to eql nil
      end
    end

  end

  # *****************************************************************

  describe "#is_order_next?" do

    context "check for order in an empty queue" do
      it "returns false" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        expect(orders.is_order_next?(order)).to be false
      end
    end

    context "check for order in a queue with one order which is not the requested order" do
      it "returns false" do
        order1 = object_double(Order.new(1,"Christian",["A","B","C"]))
        order_2 = object_double(Order.new(2,"Lauren",["D","E","F"]))
        orders = OrderUp.new
        orders.create_order(order_2)
        expect(orders.is_order_next?(order1)).to be false
      end
    end

    context "check for order in a queue with one order which is the requested order" do
      it "returns true" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        expect(orders.is_order_next?(order)).to be true
      end
    end

    context "check for order in a queue with multiple orders that has been popped until the requested order is next" do
      it "returns true" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 100
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Lauren",["D","E","F"])))
        end
        orders.create_order(order)
        for i in 1..range
          orders.complete_order
        end
        expect(orders.is_order_next?(order)).to be true
      end
    end

    context "check for order in a queue with multiple orders which doesnt contain the requested order" do
      it "returns false" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 100
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Lauren",["D","E","F"])))
        end
        expect(orders.is_order_next?(order)).to be false
      end
    end

    context "check for order in a queue with multiple orders whose next order is the requested order" do
      it "returns true" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        range = 100
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Lauren",["D","E","F"])))
        end
        expect(orders.is_order_next?(order)).to be true
      end
    end

  end

  # *****************************************************************

  describe "#view_waitlist_orders" do

    context "view order ids in an empty queue" do
      it "returns an empty string" do
        orders = OrderUp.new
        expect(orders.view_waitlist_orders).to eql ""
      end
    end

    context "view order ids in a queue with one order that was popped" do
      it "returns an empty string" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        orders.complete_order
        expect(orders.view_waitlist_orders).to eql ""
      end
    end

    context "view order ids in a queue with one order" do
      it "returns a string containing the single order id" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        allow(order).to receive(:get_id) { 1 }
        orders = OrderUp.new
        orders.create_order(order)
        expect(orders.view_waitlist_orders).to eql "1"
      end
    end

    context "view order ids in a queue with multiple orders" do
      it "returns a string containing the id of all the orders" do
        order1 = object_double(Order.new(1,"Christian",["A","E","I"]))
        order2 = object_double(Order.new(2,"Lauren",["B","F","J"]))
        order3 = object_double(Order.new(3,"Chadwick",["C","G","K"]))
        order4 = object_double(Order.new(4,"Sandra",["D","H","L"]))
        allow(order1).to receive(:get_id) { 1 }
        allow(order2).to receive(:get_id) { 2 }
        allow(order3).to receive(:get_id) { 3 }
        allow(order4).to receive(:get_id) { 4 }
        orders = OrderUp.new
        orders.create_order(order1)
        orders.create_order(order2)
        orders.create_order(order3)
        orders.create_order(order4)
        expect(orders.view_waitlist_orders).to eql "1,2,3,4"
      end
    end

    context "view order ids in a queue with multiple orders after some of which have been popped" do
      it "returns a string containing the ids of the remaining orders" do
        order1 = object_double(Order.new(1,"Christian",["A","E","I"]))
        order2 = object_double(Order.new(2,"Lauren",["B","F","J"]))
        order3 = object_double(Order.new(3,"Chadwick",["C","G","K"]))
        order4 = object_double(Order.new(4,"Sandra",["D","H","L"]))
        allow(order1).to receive(:get_id) { 1 }
        allow(order2).to receive(:get_id) { 2 }
        allow(order3).to receive(:get_id) { 3 }
        allow(order4).to receive(:get_id) { 4 }
        orders = OrderUp.new
        orders.create_order(order1)
        orders.create_order(order2)
        orders.create_order(order3)
        orders.create_order(order4)
        orders.complete_order
        orders.complete_order
        expect(orders.view_waitlist_orders).to eql "3,4"
      end
    end

    context "view order ids in a queue with multiple orders after some of which have been removed" do
      it "returns a string containing the ids of the remaining orders" do
        order1 = object_double(Order.new(1,"Christian",["A","E","I"]))
        order2 = object_double(Order.new(2,"Lauren",["B","F","J"]))
        order3 = object_double(Order.new(3,"Chadwick",["C","G","K"]))
        order4 = object_double(Order.new(4,"Sandra",["D","H","L"]))
        allow(order1).to receive(:get_id) { 1 }
        allow(order2).to receive(:get_id) { 2 }
        allow(order3).to receive(:get_id) { 3 }
        allow(order4).to receive(:get_id) { 4 }
        orders = OrderUp.new
        orders.create_order(order1)
        orders.create_order(order2)
        orders.create_order(order3)
        orders.create_order(order4)
        orders.discard_order(order4)
        orders.discard_order(order1)
        expect(orders.view_waitlist_orders).to eql "2,3"
      end
    end

  end

  # *****************************************************************

  describe "#view_waitlist_people" do

    context "view order names in an empty queue" do
      it "returns an empty string" do
        orders = OrderUp.new
        expect(orders.view_waitlist_people).to eql ""
      end
    end

    context "view order names in a queue with one order that was popped" do
      it "returns an empty string" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        orders.complete_order
        expect(orders.view_waitlist_people).to eql ""
      end
    end

    context "view order names in a queue with one order" do
      it "returns a string containing the single order name" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        allow(order).to receive(:get_name) { "Christian" }
        orders = OrderUp.new
        orders.create_order(order)
        expect(orders.view_waitlist_people).to eql "Christian"
      end
    end

    context "view orders in a queue with multiple orders" do
      it "returns a string containing the names of all the orders" do
        order1 = object_double(Order.new(1,"Christian",["A","E","I"]))
        order2 = object_double(Order.new(2,"Lauren",["B","F","J"]))
        order3 = object_double(Order.new(3,"Joesph",["C","G","K"]))
        order4 = object_double(Order.new(4,"Sandra",["D","H","L"]))
        allow(order1).to receive(:get_name) { "Christian" }
        allow(order2).to receive(:get_name) { "Lauren" }
        allow(order3).to receive(:get_name) { "Chadwick" }
        allow(order4).to receive(:get_name) { "Sandra" }
        orders = OrderUp.new
        orders.create_order(order1)
        orders.create_order(order2)
        orders.create_order(order3)
        orders.create_order(order4)
        expect(orders.view_waitlist_people).to eql "Christian,Lauren,Chadwick,Sandra"
      end
    end

    context "view orders in a queue with multiple orders after some of which have been popped" do
      it "returns a string containing the names of the remaining orders" do
        order1 = object_double(Order.new(1,"Christian",["A","E","I"]))
        order2 = object_double(Order.new(2,"Lauren",["B","F","J"]))
        order3 = object_double(Order.new(3,"Joesph",["C","G","K"]))
        order4 = object_double(Order.new(4,"Sandra",["D","H","L"]))
        allow(order1).to receive(:get_name) { "Christian" }
        allow(order2).to receive(:get_name) { "Lauren" }
        allow(order3).to receive(:get_name) { "Chadwick" }
        allow(order4).to receive(:get_name) { "Sandra" }
        orders = OrderUp.new
        orders.create_order(order1)
        orders.create_order(order2)
        orders.create_order(order3)
        orders.create_order(order4)
        orders.complete_order
        orders.complete_order
        expect(orders.view_waitlist_people).to eql "Chadwick,Sandra"
      end
    end

    context "view orders in a queue with multiple orders after some of which have been removed" do
      it "returns a string containing the names of the remaining orders" do
        order1 = object_double(Order.new(1,"Christian",["A","E","I"]))
        order2 = object_double(Order.new(2,"Lauren",["B","F","J"]))
        order3 = object_double(Order.new(3,"Joesph",["C","G","K"]))
        order4 = object_double(Order.new(4,"Sandra",["D","H","L"]))
        allow(order1).to receive(:get_name) { "Christian" }
        allow(order2).to receive(:get_name) { "Lauren" }
        allow(order3).to receive(:get_name) { "Chadwick" }
        allow(order4).to receive(:get_name) { "Sandra" }
        orders = OrderUp.new
        orders.create_order(order1)
        orders.create_order(order2)
        orders.create_order(order3)
        orders.create_order(order4)
        orders.discard_order(order4)
        orders.discard_order(order1)
        expect(orders.view_waitlist_people).to eql "Lauren,Chadwick"
      end
    end

  end

  # *****************************************************************

  describe "#waitlist_position" do

    context "check for order in an empty queue" do
      it "returns -1" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        expect(orders.waitlist_position(order)).to equal -1
      end
    end

    context "check for order in a queue with one order which is not the requested order" do
      it "returns -1" do
        order1 = object_double(Order.new(1,"Christian",["A","B","C"]))
        order_2 = object_double(Order.new(2,"Lauren",["D","E","F"]))
        orders = OrderUp.new
        orders.create_order(order_2)
        expect(orders.waitlist_position(order1)).to equal -1
      end
    end

    context "check for order in a queue with one order which is the requested order" do
      it "returns 1" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        expect(orders.waitlist_position(order)).to equal 1
      end
    end

    context "check for order in a queue with multiple orders that has been popped until the requested order is next" do
      it "returns 1" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 100
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Lauren",["D","E","F"])))
        end
        orders.create_order(order)
        for i in 1..range
          orders.complete_order
        end
        expect(orders.waitlist_position(order)).to equal 1
      end
    end

    context "check for order in a queue with multiple orders which doesnt contain the requested order" do
      it "returns -1" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 100
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Lauren",["D","E","F"])))
        end
        expect(orders.waitlist_position(order)).to equal -1
      end
    end

    context "check for order in a queue with multiple orders in which the requested order exists" do
      it "returns the position of the request order" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 100
        for i in 1..range
          if i == range/2
            orders.create_order(order)
          end
          orders.create_order(object_double(Order.new(i,"Lauren",["D","E","F"])))
        end
        expect(orders.waitlist_position(order)).to equal range/2
      end
    end

    context "check for order in a queue with multiple orders whose next order is the requested order" do
      it "returns 1" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        range = 100
        for i in 1..range
          orders.create_order(object_double(Order.new(i,"Lauren",["D","E","F"])))
        end
        expect(orders.waitlist_position(order)).to equal 1
      end
    end

  end

  # *****************************************************************

  describe "#waitlist_size" do

    context "when the queue is empty" do
      it "returns 0" do
        orders = OrderUp.new
        expect(orders.waitlist_size).to equal 0
      end
    end

    context "when the queue contained one order but was popped" do
      it "returns 0" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        orders.complete_order
        expect(orders.waitlist_size).to equal 0
      end
    end

    context "when the queue contained multiple orders but was popped until empty" do
      it "returns 0" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 1000
        for i in 1..range
          orders.create_order(order)
        end
        for i in 1..range
          orders.complete_order
        end
        expect(orders.waitlist_size).to equal 0
      end
    end

    context "when the queue contains one order" do
      it "returns 1" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        expect(orders.waitlist_size).to equal 1
      end
    end

    context "when the queue contains multiple orders" do
      it "returns the size of the queue" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 1000
        for i in 1..range
          orders.create_order(order)
        end
        expect(orders.waitlist_size).to equal range
      end
    end

    context "when the queue contains multiple orders and pops several of them" do
      it "returns the new size of the queue" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 1000
        for i in 1..range
          orders.create_order(order)
        end
        for i in 1..range/2
          orders.complete_order
        end
        expect(orders.waitlist_size).to equal range/2
      end
    end

  end

  # *****************************************************************

  describe "#reset!" do

    context "when the queue is empty" do
      it "causes the size of the queue to remain zero" do
        orders = OrderUp.new
        expect(orders.waitlist_size).to equal 0
        orders.reset!
        expect(orders.waitlist_size).to equal 0
      end
    end

    context "when the queue contains one order" do
      it "decreases the size of the queue from one to zero" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        orders.create_order(order)
        expect(orders.waitlist_size).to equal 1
        orders.reset!
        expect(orders.waitlist_size).to equal 0
      end
    end

    context "when the queue contains multiple orders" do
      it "decreases the size of the queue to zero" do
        order = object_double(Order.new(1,"Christian",["A","B","C"]))
        orders = OrderUp.new
        range = 100
        for i in 1..range
          orders.create_order(order)
        end
        expect(orders.waitlist_size).to equal range
        orders.reset!
        expect(orders.waitlist_size).to equal 0
      end
    end

  end

  # *****************************************************************

end
