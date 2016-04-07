require_relative "Node"

class Queue

  # Initializes the Queue
  def initialize
    @first = nil
    @last = nil
    @size = 0
  end

  # Add node to the end of the Queue
  def enqueue(data)
    node = Node.new(data)
    temp = @last
    @last = node
    if self.is_empty?
      @first = @last
    else
      temp.set_next(node)
    end
    @size += 1
  end

  # Remove node from the beginning of the Queue
  def dequeue
    data = nil
    unless self.is_empty?
      data = @first.get_data
      @first = @first.get_next
      @size -= 1
    end
    data
  end

  # View node at the beginning of the Queue
  def peek
    data = nil
    unless self.is_empty?
      data = @first.get_data
    end
    data
  end

  # Remove node with specified data from the Queue (first occurence only)
  def remove(data)
    removed = false
    count = 0
    unless self.is_empty?
      if @first.get_data == data
        @first = @first.get_next
        removed = true
        @size -= 1
      else
        before = @first
        current = @first.get_next
        until (current == nil)
          if current.get_data == data
            before.set_next(current.get_next)
            @size -= 1
            if count == @size
              @last = before
            end
            removed = true
            break
          end
          before = current
          current = current.get_next
          count += 1
        end
      end
    end
    removed
  end

  # Find position of node with specified data in the Queue
  def position_of(data)
    position = -1
    unless self.is_empty?
      node = @first
      count = 1
      until (node == nil)
        if node.get_data == data
          position = count
          break
        end
        node = node.get_next
        count += 1
      end
    end
    position
  end

  # Determine if Queue contains node with specified data
  def contains?(data)
    position_of(data) != -1
  end

  # Reset the Queue
  def clear!
    @first = nil
    @last = nil
    @size = 0
  end

  # Determine if Queue is empty
  def is_empty?
    @size == 0
  end

  # Determine size of Queue
  def size
    @size
  end

  # Convert Queue to an array
  def to_array
    array = []
    node = @first
    until (node == nil)
      array << node.get_data
      node = node.get_next
    end
    array
  end

  # Concatenate data from each each node in the Queue and return as a string
  def to_str
    str = ""
    node = @first
    until (node == nil)
      str += node.get_data.to_str + "\n"
      node = node.get_next
    end
    str
  end

end
