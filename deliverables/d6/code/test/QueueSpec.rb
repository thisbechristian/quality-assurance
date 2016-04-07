require_relative 'Header'

describe Queue do

  # *****************************************************************

  describe "#new" do

    context "when a Queue is created" do
      it "takes no parameters and returns a Queue object" do
        queue = Queue.new
        expect(queue).to be_an_instance_of Queue
      end
    end

  end

  # *****************************************************************

  describe "#enqueue" do

    context "when a node is added to an empty Queue" do
      it "increases the size of the Queue from zero to one" do
        data = "data"
        queue = Queue.new
        size1 = queue.size
        expect(size1).to eql 0
        queue.enqueue(data)
        size2 = queue.size
        expect(size2).to eql 1
      end
    end

    context "when a node is added to an empty Queue" do
      it "is no longer empty" do
        data = "data"
        queue = Queue.new
        empty = queue.is_empty?
        expect(empty).to be true
        queue.enqueue(data)
        empty = queue.is_empty?
        expect(empty).to eql false
      end
    end

    context "when a node is added to a Queue with one node" do
      it "increases the size of the Queue from one to two" do
        data = "data"
        queue = Queue.new
        queue.enqueue(data)
        size1 = queue.size
        expect(size1).to eql 1
        queue.enqueue(data)
        size2 = queue.size
        expect(size2).to eql 2
      end
    end

    context "when a node is added to a Queue with multiple nodes" do
      it "increases the size of the Queue by one" do
        data = "data"
        queue = Queue.new
        range = 100
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        size1 = queue.size
        expect(size1).to eql range
        queue.enqueue(data)
        size2 = queue.size
        expect(size2).to eql range+1
      end
    end

  end

  # *****************************************************************

  describe "#dequeue" do

    context "when a node is popped from an empty Queue" do
      it "causes the size of the Queue to remain at zero" do
        queue = Queue.new
        size1 = queue.size
        expect(size1).to eql 0
        queue.dequeue
        size2 = queue.size
        expect(size2).to eql 0
      end
    end

    context "when a node is popped from an empty Queue" do
      it "causes the Queue to remain empty" do
        queue = Queue.new
        empty = queue.is_empty?
        expect(empty).to be true
        queue.dequeue
        empty = queue.is_empty?
        expect(empty).to be true
      end
    end

    context "when a node is popped from a Queue with one node" do
      it "decreases the size of the Queue from one to zero" do
        data = "data"
        queue = Queue.new
        queue.enqueue(data)
        size1 = queue.size
        expect(size1).to eql 1
        queue.dequeue
        size2 = queue.size
        expect(size2).to eql 0
      end
    end

    context "when a node is popped from a Queue with multiple nodes" do
      it "decreases the size of the queue by one" do
        data = "data"
        queue = Queue.new
        range = 100
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        size1 = queue.size
        expect(size1).to eql range
        queue.dequeue
        size2 = queue.size
        expect(size2).to eql range-1
      end
    end

  end

  # *****************************************************************

  describe "#peek" do

    context "when a node is added to an empty Queue" do
      it "returns the data of the new node" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        expect(queue.peek).to eql data
      end
    end

    context "when a node is added to a Queue with a previous node" do
      it "returns the data of the first node" do
        queue = Queue.new
        data1 = "first"
        data2 = "last"
        queue.enqueue(data1)
        queue.enqueue(data2)
        expect(queue.peek).to eql data1
      end
    end

    context "when a node is added to a Queue with multiple previous nodes" do
      it "returns the data of the first node" do
        data1 = "first"
        queue = Queue.new
        queue.enqueue(data1)
        range = 100
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        data2 = "last"
        queue.enqueue(data2)
        expect(queue.peek).to eql data1
      end
    end

    context "when two nodes are in the Queue and the Queue is popped" do
      it "returns the data of the second node" do
        queue = Queue.new
        data1 = "first"
        data2 = "second"
        queue.enqueue(data1)
        queue.enqueue(data2)
        queue.dequeue
        expect(queue.peek).to eql data2
      end
    end

    context "when one node is in the Queue and the Queue is popped" do
      it "returns nil" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        queue.dequeue
        expect(queue.peek).to be_nil
      end
    end

  end

  # *****************************************************************

  describe "#remove" do

    context "when the Queue is empty" do
      it "does not remove the node and returns false" do
        queue = Queue.new
        data = "data"
        expect(queue.remove(data)).to be false
      end
    end

    context "when the Queue contains multiple nodes discluding the requested node" do
      it "does not remove the node and returns false" do
        queue = Queue.new
        data = "data"
        range = 100
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        expect(queue.remove(data)).to be false
      end
    end

    context "when the Queue contains multiple nodes including the requested node" do
      it "removes the node and returns true" do
        queue = Queue.new
        data = "data"
        range = 100
        queue.enqueue(data)
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        expect(queue.remove(data)).to be true
        expect(queue.contains?(data)).to be false
      end
    end

    context "when the Queue contains multiple nodes including duplicates of the requested node" do
      it "removes the first occurance of the node and returns true" do
        queue = Queue.new
        data = "data"
        range = 100
        queue.enqueue(data)
        queue.enqueue(data)
        queue.enqueue(data)
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        size = queue.size
        expect(queue.remove(data)).to be true
        expect(queue.size).to equal size-1
      end
    end

    context "when the Queue contains the requested node but it is popped" do
      it "returns false" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        queue.dequeue
        expect(queue.remove(data)).to be false
      end
    end

    context "when the Queue contains one node which is not the requested node" do
      it "returns false" do
        queue = Queue.new
        data = "data"
        queue.enqueue("not")
        expect(queue.remove(data)).to be false
      end
    end

    context "when the Queue contains one node which is the requested node" do
      it "returns true" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        expect(queue.remove(data)).to be true
      end
    end

  end

  # *****************************************************************

  describe "#position_of" do

    context "when the Queue is empty" do
      it "returns -1" do
        queue = Queue.new
        data = "data"
        expect(queue.position_of(data)).to equal -1
      end
    end

    context "when the Queue contains multiple nodes discluding the requested node" do
      it "returns -1" do
        queue = Queue.new
        data = "data"
        range = 100
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        expect(queue.position_of(data)).to equal -1
      end
    end

    context "when the Queue contains multiple nodes including the requested node" do
      it "returns the position of the node" do
        queue = Queue.new
        data = "data"
        range = 100
        queue.enqueue(data)
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        expect(queue.position_of(data)).not_to equal -1
      end
    end

    context "when the Queue contains multiple nodes including duplicates of the requested node" do
      it "returns the position of the first occurance of the node" do
        queue = Queue.new
        data = "data"
        range = 100
        queue.enqueue(data)
        queue.enqueue(data)
        queue.enqueue(data)
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        expect(queue.position_of(data)).to equal 1
      end
    end

    context "when the Queue contains the requested node but it is popped" do
      it "returns -1" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        queue.dequeue
        expect(queue.position_of(data)).to equal -1
      end
    end

    context "when the Queue contains the requested node but it is removed" do
      it "returns -1" do
        queue = Queue.new
        data = "data"
        range = 100
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        queue.remove(data)
        expect(queue.position_of(data)).to equal -1
      end
    end

    context "when the Queue contains one node which is not the requested node" do
      it "returns -1" do
        queue = Queue.new
        data = "data"
        queue.enqueue("not")
        expect(queue.position_of(data)).to equal -1
      end
    end

    context "when the Queue contains one node which is the requested node" do
      it "returns 1" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        expect(queue.position_of(data)).to equal 1
      end
    end

  end

  # *****************************************************************

  describe "#contains?" do

    context "when the Queue is empty" do
      it "returns false" do
        queue = Queue.new
        data = "data"
        expect(queue.contains?(data)).to be false
      end
    end

    context "when the Queue contains multiple nodes discluding the requested node" do
      it "returns false" do
        queue = Queue.new
        data = "data"
        range = 100
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        expect(queue.contains?(data)).to be false
      end
    end

    context "when the Queue contains multiple nodes including the requested node" do
      it "returns true" do
        queue = Queue.new
        data = "data"
        range = 100
        queue.enqueue(data)
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        expect(queue.contains?(data)).to be true
      end
    end

    context "when the Queue contains multiple nodes including duplicates of the requested node" do
      it "returns true" do
        queue = Queue.new
        data = "data"
        range = 100
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        queue.enqueue(data)
        queue.enqueue(data)
        queue.enqueue(data)
        expect(queue.contains?(data)).to be true
      end
    end

    context "when the Queue contains the requested node but it is popped" do
      it "returns false" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        queue.dequeue
        expect(queue.contains?(data)).to be false
      end
    end

    context "when the Queue contains the requested node but it is removed" do
      it "returns false" do
        queue = Queue.new
        data = "data"
        range = 100
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
        end
        queue.remove(data)
        expect(queue.contains?(data)).to be false
      end
    end

    context "when the Queue contains one node which is not the requested node" do
      it "returns false" do
        queue = Queue.new
        data = "data"
        queue.enqueue("not")
        expect(queue.contains?(data)).to be false
      end
    end

    context "when the Queue contains one node which is the requested node" do
      it "returns true" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        expect(queue.contains?(data)).to be true
      end
    end

  end

  # *****************************************************************

  describe "#clear!" do

    context "when the Queue is empty" do
      it "causes the size of the Queue to remain zero" do
        queue = Queue.new
        expect(queue.size).to equal 0
        queue.clear!
        expect(queue.size).to equal 0
      end
    end

    context "when the Queue contains one node" do
      it "decreases the size of the Queue from one to zero" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        expect(queue.size).to equal 1
        queue.clear!
        expect(queue.size).to equal 0
      end
    end

    context "when the Queue contains multiple nodes" do
      it "decreases the size of the Queue to zero" do
        queue = Queue.new
        data = "data"
        range = 100
        for i in 1..range
          queue.enqueue(data)
        end
        expect(queue.size).to equal range
        queue.clear!
        expect(queue.size).to equal 0
      end
    end

  end

  # *****************************************************************

  describe "#is_empty?" do

    context "when the Queue is empty" do
      it "returns true" do
        queue = Queue.new
        expect(queue.is_empty?).to be true
      end
    end

    context "when the Queue contained one node but was popped" do
      it "returns false" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        queue.dequeue
        expect(queue.is_empty?).to be true
      end
    end

    context "when the Queue contained multiple nodes but was popped until empty" do
      it "returns true" do
        queue = Queue.new
        data = "data"
        range = 1000
        for i in 1..range
          queue.enqueue(data)
        end
        for i in 1..range
          queue.dequeue
        end
        expect(queue.is_empty?).to be true
      end
    end

    context "when the Queue contains one node" do
      it "returns false" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        expect(queue.is_empty?).to be false
      end
    end

    context "when the Queue contains multiple nodes" do
      it "returns false" do
        queue = Queue.new
        data = "data"
        range = 1000
        for i in 1..range
          queue.enqueue(data)
        end
        expect(queue.is_empty?).to be false
      end
    end

    context "when the Queue contains multiple nodes and pops several of them" do
      it "returns false" do
        queue = Queue.new
        data = "data"
        range = 1000
        for i in 1..range
          queue.enqueue(data)
        end
        for i in 1..range/2
          queue.dequeue
        end
        expect(queue.is_empty?).to be false
      end
    end

  end

  # *****************************************************************

  describe "#to_array" do

    context "when the Queue is empty" do
      it "returns an empty array" do
        queue = Queue.new
        expect(queue.to_array).to match_array([])
      end
    end

    context "when the Queue contained one node but was popped" do
      it "returns an empty array" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        queue.dequeue
        expect(queue.to_array).to match_array([])
      end
    end

    context "when the Queue contained multiple nodes but was popped until empty" do
      it "returns an empty array" do
        queue = Queue.new
        data = "data"
        range = 1000
        for i in 1..range
          queue.enqueue(data)
        end
        for i in 1..range
          queue.dequeue
        end
        expect(queue.to_array).to match_array([])
      end
    end

    context "when the Queue contains one node" do
      it "returns an array containing the data of the single node" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        expect(queue.to_array).to match_array(["data"])
      end
    end

    context "when the Queue contains multiple nodes" do
      it "returns an array containing all the data of the nodes" do
        queue = Queue.new
        array = []
        range = 100
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
          array.push(temp)
        end
        expect(queue.to_array).to match_array(array)
      end
    end

    context "when the Queue contains multiple nodes and pops several of them" do
      it "returns an array containing all the data of the up-popped nodes" do
        queue = Queue.new
        array = []
        range = 10
        for i in 1..range
          temp = "data" + i.to_s
          queue.enqueue(temp)
          array.push(temp)
        end
        for i in 1..range/2
          queue.dequeue
          array.shift
        end
        expect(queue.to_array).to match_array(array)
      end
    end

  end

  # *****************************************************************

  describe "#size" do

    context "when the Queue is empty" do
      it "returns 0" do
        queue = Queue.new
        expect(queue.size).to equal 0
      end
    end

    context "when the Queue contained one node but was popped" do
      it "returns 0" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        queue.dequeue
        expect(queue.size).to equal 0
      end
    end

    context "when the Queue contained multiple nodes but was popped until empty" do
      it "returns 0" do
        queue = Queue.new
        data = "data"
        range = 1000
        for i in 1..range
          queue.enqueue(data)
        end
        for i in 1..range
          queue.dequeue
        end
        expect(queue.size).to equal 0
      end
    end

    context "when the Queue contains one node" do
      it "returns 1" do
        queue = Queue.new
        data = "data"
        queue.enqueue(data)
        expect(queue.size).to equal 1
      end
    end

    context "when the Queue contains multiple nodes" do
      it "returns the size of the queue" do
        queue = Queue.new
        data = "data"
        range = 1000
        for i in 1..range
          queue.enqueue(data)
        end
        expect(queue.size).to equal range
      end
    end

    context "when the Queue contains multiple nodes and pops several of them" do
      it "returns the new size of the queue" do
        queue = Queue.new
        data = "data"
        range = 1000
        for i in 1..range
          queue.enqueue(data)
        end
        for i in 1..range/2
          queue.dequeue
        end
        expect(queue.size).to equal range/2
      end
    end

  end

# *****************************************************************

end
