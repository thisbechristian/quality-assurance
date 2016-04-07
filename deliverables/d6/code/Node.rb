class Node
  # Initializes the Node with the given data
  def initialize(data)
    if !data.nil?
      @next = nil
      @data = data
    else
      raise "Oops, the data parameter cannot be nil"
    end
  end

  # Returns the Node's Next Node
  def get_next
    @next
  end

  # Sets the Node's Next Node
  def set_next(node)
    @next = node
  end

  # Returns true if the Node's Next Node exists,
  # Returns false if the Node's Next Node is equal to nil
  def has_next?
    !@next.nil?
  end

  # Returns the Node's data
  def get_data
    @data
  end

  # Sets the Node's data
  def set_data(data)
    unless data.nil?
      @data = data
    end
    @data
  end
end
