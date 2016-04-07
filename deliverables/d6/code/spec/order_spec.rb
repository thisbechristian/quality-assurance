require 'spec_helper'

describe Order do

  # *****************************************************************

  describe "#new" do

    context "when an Order is created without an array of items" do
      it "takes two parameters (id, name) and returns an Order object" do
        id = 10
        name = "Christian"
        order = Order.new(id,name)
        expect(order).to be_an_instance_of Order
      end
    end

    context "when an Order is created with an array of items" do
      it "takes three parameters (id, name, items) and returns an Order object" do
        id = 100
        name = "Chad"
        items = ["Hamburger", "Hotdog", "Salad"]
        order = Order.new(id,name,items)
        expect(order).to be_an_instance_of Order
      end
    end

    context "when an Order is created with an array of one item" do
      it "takes three parameters (id, name, items) and returns an Order object" do
        id = "ABC365"
        name = "Jasmine"
        items = ["Cheese"]
        order = Order.new(id,name,items)
        expect(order).to be_an_instance_of Order
      end
    end

    context "when an Order is created with an empty array of items" do
      it "takes three parameters (id, name, items) and returns an Order object" do
        id = 1000
        name = "Jessica"
        items = []
        order = Order.new(id,name,items)
        expect(order).to be_an_instance_of Order
      end
    end

    context "when an Order is created with just a single variable" do
      it "takes three parameters (id, name, items) and returns an Order object" do
        id = 1
        name = "Harry"
        items = 1
        order = Order.new(id,name,items)
        expect(order).to be_an_instance_of Order
      end
    end

    context "when an Order is created with a nil value for id" do
      it "takes two parameters (id, name) and raises an error" do
        id = nil
        name = "George"
        expect { Order.new(id,name) }.to raise_error("Oops, the id and name parameters cannot be nil")
      end
    end

    context "when an Order is created with a nil value for name" do
      it "takes two parameters (id, name) and raises an error" do
        id = 123
        name = nil
        expect { Order.new(id,name) }.to raise_error("Oops, the id and name parameters cannot be nil")
      end
    end

    context "when an Order is created with nil values for both id and name" do
      it "takes two parameters (id, name) and raises an error" do
        id = nil
        name = nil
        expect { Order.new(id,name) }.to raise_error("Oops, the id and name parameters cannot be nil")
      end
    end

  end

  # *****************************************************************

  describe "#get_id" do

    context "when an Order is initialized with an id and name" do
      it "returns the id in which the Order was initialized with" do
        id = 3
        name = "Josh"
        order = Order.new(id,name)
        expect(order.get_id).to eql 3
      end
    end

    context "when an Order is initialized with an id, name, and array of items" do
      it "returns the id in which the Order was initialized with" do
        id = "11C"
        name = "Lauren"
        items = ["Tomatoes", "Soup", "Pickles"]
        order = Order.new(id,name,items)
        expect(order.get_id).to eql "11C"
      end
    end

  end

  # *****************************************************************

  describe "#set_id" do

    context "when an Order's id is set" do
      it "returns the new id" do
        id = 6
        name = "Douglas"
        changed = 8
        order = Order.new(id,name)
        order.set_id(changed)
        expect(order.get_id).to eql 8
      end
    end

    context "when an Order's id is set to nil" do
      it "returns the old id" do
        id = "13A"
        name = "Roxanne"
        order = Order.new(id,name)
        order.set_id(nil)
        expect(order.get_id).to eql "13A"
      end
    end

  end

  # *****************************************************************

  describe "#get_name" do

    context "when an Order is initialized with an id and name" do
      it "returns the name in which the Order was initialized with" do
        id = 1986
        name = "Bill"
        order = Order.new(id,name)
        expect(order.get_name).to eql "Bill"
      end
    end

    context "when an Order is initialized with an id, name, and array of items" do
      it "returns the name in which the Order was initialized with" do
        id = 120912
        name = "Frank"
        items = ["Milk", "Eggs", "Bread"]
        order = Order.new(id,name,items)
        expect(order.get_name).to eql "Frank"
      end
    end

  end

  # *****************************************************************

  describe "#set_name" do

    context "when an Order's name is set" do
      it "returns the new name" do
        id = "23434AKJABDJKBDSF"
        name = "Craig"
        changed = "David"
        order = Order.new(id,name)
        order.set_name(changed)
        expect(order.get_name).to eql "David"
      end
    end

    context "when an Order's name is set to nil" do
      it "returns the old name" do
        id = "YASD23948273"
        name = "Jonesy"
        order = Order.new(id,name)
        order.set_name(nil)
        expect(order.get_name).to eql "Jonesy"
      end
    end

  end

  # *****************************************************************

  describe "#get_items" do

    context "when an Order is initialized with an id, name, and an array of items" do
      it "returns an array of items in which the Order was initialized with" do
        id = 912314
        name = "Hilary"
        items = ["Water", "Chicken", "Juice", "Toast"]
        order = Order.new(id,name,items)
        expect(order.get_items).to match_array(items.map(&:downcase))
      end
    end

    context "when an Order is initialized with an id, name, and one item" do
      it "returns an array of the one item in which the Order was initialized with" do
        id = 3242382342353469387
        name = "Claire"
        item = "Salad"
        items = ["Salad"]
        order = Order.new(id,name,item)
        expect(order.get_items).to match_array(items.map(&:downcase))
      end
    end

    context "when an Order is initialized with an id, name, and an empty array" do
      it "returns an empty array in which the Order was initialized with" do
        id = "4564ABHGAFS"
        name = "Houston"
        items = []
        order = Order.new(id,name,items)
        expect(order.get_items).to match_array(items)
      end
    end

  end

  # *****************************************************************

  describe "#set_items" do

    context "when an Order's items are set to an array of items" do
      it "returns a new array of items" do
        id = "ABC123"
        name = "Shelia"
        items = ["Corn", "Beef", "Apples"]
        order = Order.new(id,name)
        order.set_items(items)
        expect(order.get_items).to match_array(items.map(&:downcase))
      end
    end

    context "when an Order's items are set to two arrays of items" do
      it "returns a the second array of items" do
        id = "ABC123"
        name = "Shelia"
        items1 = ["Corn", "Beef", "Apples"]
        items2 = ["Oranges", "Pears", "Grapes"]
        order = Order.new(id,name)
        order.set_items(items1)
        order.set_items(items2)
        expect(order.get_items).to match_array(items2.map(&:downcase))
      end
    end

    context "when an Order's items are set to a new arrays of items" do
      it "returns a new array of items" do
        id = "ABC123"
        name = "Shelia"
        items = ["Corn", "Beef", "Apples"]
        order = Order.new(id,name,items)
        items = ["Oranges", "Pears", "Grapes"]
        order.set_items(items)
        expect(order.get_items).to match_array(items.map(&:downcase))
      end
    end

    context "when an Order's items are set a single item" do
      it "returns the existing array of items" do
        id = 324238234235
        name = "Stephanie"
        item = "Cheese"
        items = ["Pizza", "Chips"]
        order = Order.new(id,name,items)
        order.set_items(item)
        expect(order.get_items).to match_array(items.map(&:downcase))
      end
    end

  end

  # *****************************************************************

  describe "#add_item" do

    context "when adding an item to an Order with no items" do
      it "returns a new array containing only the new item" do
        id = 429
        name = "John"
        item = "Pork"
        items = ["Pork"]
        order = Order.new(id,name)
        order.add_item(item)
        expect(order.get_items).to match_array(items.map(&:downcase))
      end
    end

    context "when adding an item to an Order with multiple items" do
      it "returns a new array containing all of the items" do
        id = "73242rffad453dgasjydf"
        name = "George"
        items = ["Beef", "Beans", "Cabbage", "Corn", "Cake", "Orange Juice"]
        item = "Carrots"
        order = Order.new(id,name,items)
        order.add_item(item)
        items.push(item)
        expect(order.get_items).to match_array(items.map(&:downcase))
      end
    end

    context "when adding nil to an Order with multiple items" do
      it "returns the existing array of items" do
        id = 123456
        name = "Karen"
        items = ["Cereal", "Milk", "Muffin", "Donut"]
        order = Order.new(id,name,items)
        order.add_item(nil)
        expect(order.get_items).to match_array(items.map(&:downcase))
      end
    end

  end

  # *****************************************************************

  describe "#delete_item" do

    context "when deleting an item from an Order with no items" do
      it "returns an empty array" do
        id = 0
        name = "No-Name"
        item = "Milk"
        order = Order.new(id,name)
        order.delete_item(item)
        expect(order.get_items).to match_array([])
      end
    end

    context "when deleting an item that exists from an Order with multiple items" do
      it "returns a new array of items, discluding the removed item" do
        id = "43076374865345"
        name = "Robert"
        items = ["Beef", "Beans", "Cabbage", "Corn", "Cake", "Orange Juice"]
        item = "Beans"
        order = Order.new(id,name,items)
        order.delete_item(item)
        items.delete(item)
        expect(order.get_items).to match_array(items.map(&:downcase))
      end
    end

    context "when deleting an item that does not exist from an Order with multiple items" do
      it "returns the existing array of items" do
        id = "43076374865345"
        name = "Robert"
        items = ["Beef", "Beans", "Cabbage", "Corn", "Cake", "Orange Juice"]
        item = "Tacos"
        order = Order.new(id,name,items)
        order.delete_item(item)
        expect(order.get_items).to match_array(items.map(&:downcase))
      end
    end

    context "when deleting nil from an Order with multiple items" do
      it "returns the existing array of items" do
        id = 237545634
        name = "Corey"
        items = ["Cheesecake", "Juice", "Eggs", "Lettuce"]
        order = Order.new(id,name,items)
        order.delete_item(nil)
        expect(order.get_items).to match_array(items.map(&:downcase))
      end
    end

  end

  # *****************************************************************

  describe "#to_str" do

    context "when an Order is initialized with an id and a name" do
      it "returns a string containing the id, name, and no items" do
        id = "HEXA117562812DECIMAL"
        name = "Christian"
        order = Order.new(id,name)
        expected = "Id: " + id.to_s + "\nName: " + name.to_s + "\nItem(s): \n"
        observed = order.to_str
        expect(observed).to eql expected
      end
    end

    context "when an Order is initialized with an id, name, and array of items" do
      it "returns a string containing the id, name, and items" do
        id = 123
        name = "Christian"
        items = ["Milk", "Oats", "Honey"]
        order = Order.new(id,name,items)
        expected = "Id: " + id.to_s + "\nName: " + name.to_s + "\nItem(s): \n" + ">milk \n>oats \n>honey \n"
        observed = order.to_str
        expect(observed).to eql expected
      end
    end

  end

  # *****************************************************************

  describe "#==" do

    context "when comparing two Orders with both identical ids and names" do
      it "returns true" do
        id = 123
        name = "Nick"
        order1 = Order.new(id,name)
        order2 = Order.new(id,name)
        expect(order1).to eq order2
      end
    end

    context "when comparing two Orders with identical ids but different names" do
      it "returns false" do
        id = 123
        name1 = "Craig"
        name2 = "Dave"
        order1 = Order.new(id,name1)
        order2 = Order.new(id,name2)
        expect(order1).not_to eq order2
      end
    end

    context "when comparing two Orders with identical names but different ids" do
      it "returns false" do
        id1 = 123
        id2 = 456
        name = "Nick"
        order1 = Order.new(id1,name)
        order2 = Order.new(id2,name)
        expect(order1).not_to eq order2
      end
    end

    context "when comparing two Orders with both different ids and names" do
      it "returns false" do
        id1 = 123
        id2 = 456
        name1 = "Craig"
        name2 = "Dave"
        order1 = Order.new(id1,name1)
        order2 = Order.new(id2,name2)
        expect(order1).not_to eq order2
      end
    end

  end

  # *****************************************************************

  describe "#eql?" do

    context "when comparing two Orders with both identical ids and names" do
      it "returns true" do
        id = 123
        name = "Nick"
        order1 = Order.new(id,name)
        order2 = Order.new(id,name)
        expect(order1).to eql order2
      end
    end

    context "when comparing two Orders with identical ids but different names" do
      it "returns false" do
        id = 123
        name1 = "Craig"
        name2 = "Dave"
        order1 = Order.new(id,name1)
        order2 = Order.new(id,name2)
        expect(order1).not_to eql order2
      end
    end

    context "when comparing two Orders with identical names but different ids" do
      it "returns false" do
        id1 = 123
        id2 = 456
        name = "Nick"
        order1 = Order.new(id1,name)
        order2 = Order.new(id2,name)
        expect(order1).not_to eql order2
      end
    end

    context "when comparing two Orders with both different ids and names" do
      it "returns false" do
        id1 = 123
        id2 = 456
        name1 = "Craig"
        name2 = "Dave"
        order1 = Order.new(id1,name1)
        order2 = Order.new(id2,name2)
        expect(order1).not_to eql order2
      end
    end

  end

  # *****************************************************************

end
