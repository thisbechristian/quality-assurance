require_relative 'Header'

describe Node do

  # *****************************************************************

  describe "#new" do

    context "when a Node is created" do
      it "takes one parameter (data) and returns a Node object" do
        data = "data"
        node = Node.new(data)
        expect(node).to be_an_instance_of Node
      end
    end

    context "when a Node is created with a nil value for data" do
      it "takes one parameter (data) and raises an error" do
        data = nil
        expect { Node.new(data) }.to raise_error("Oops, the data parameter cannot be nil")
      end
    end

  end

  # *****************************************************************

  describe "#get_next" do

    context "when a Node is first initialized" do
      it "returns nil" do
        data = "data"
        node = Node.new(data)
        expect(node.get_next).to be_nil
      end
    end

  end

  # *****************************************************************

  describe "#set_next" do

    context "when a Node's Next Node (next) is set" do
      it "returns the Next Node (next)" do
        data = "data1"
        node_1 = Node.new(data)
        data = "data2"
        node_2 = Node.new(data)
        node_1.set_next(node_2)
        expect(node_1.get_next).to equal node_2
      end
    end

    context "when a Node's Next Node (next) is set to nil" do
      it "returns nil" do
        data = "data"
        node = Node.new(data)
        node.set_next(nil)
        expect(node.get_next).to be_nil
      end
    end

  end

  # *****************************************************************

  describe "#has_next?" do

    context "when a Node is first initialized" do
      it "returns false" do
        data = "data"
        node = Node.new(data)
        expect(node.has_next?).to be false
      end
    end

    context "when a Node's Next Node (next) is set" do
      it "returns true" do
        data = "data"
        node_1 = Node.new(data)
        node_2 = Node.new(data)
        node_1.set_next(node_2)
        expect(node_1.has_next?).to be true
      end
    end

    context "when a Node's Next Node (next) is set to nil" do
      it "returns false" do
        data = "data"
        node = Node.new(data)
        node.set_next(nil)
        expect(node.has_next?).to be false
      end
    end

  end

  # *****************************************************************

  describe "#get_data" do

    context "when a Node is initialized with data" do
      it "returns the data in which the Node was initialized with" do
        data = "data"
        node = Node.new(data)
        expect(node.get_data).to eql "data"
      end
    end

  end

  # *****************************************************************

  describe "#set_data" do

    context "when a Node's data is set" do
      it "returns the new data" do
        data = "old"
        node = Node.new(data)
        changed = "new"
        node.set_data(changed)
        expect(node.get_data).to eql "new"
      end

    end

    context "when a Node's data is set to nil" do
      it "returns the old data" do
        data = "old"
        node = Node.new(data)
        node.set_data(nil)
        expect(node.get_data).to eql "old"
      end
    end

  end

  # *****************************************************************

end
