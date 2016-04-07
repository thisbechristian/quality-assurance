class Order

  # Initializes the Order with the given id, number, and *option* array of items
  def initialize(id, name, items=[])
    if !id.nil? && !name.nil?
      @id = id
      @name = name
      @items = []
      if items.respond_to? :each
        items.each do |item|
          @items.push(item.to_s.downcase)
        end
      else
        unless items.nil?
          @items.push(items.to_s.downcase)
        end
      end
    else
      raise "Oops, the id and name parameters cannot be nil"
    end
  end

  # Returns the Order's Id
  def get_id
    @id
  end

  # Sets the Order's Id
  def set_id(id)
    unless id.nil?
      @id = id
    end
    @id
  end

  # Returns the Order's Name
  def get_name
    @name
  end

  # Sets the Order's Name
  def set_name(name)
    unless name.nil?
      @name = name
    end
    @name
  end

  # Returns the Order's array of items
  def get_items
    @items
  end

  # Sets the Order's array of items
  def set_items(items)
    if items.respond_to? :each
      @items = []
      items.each do |item|
        @items.push(item.to_s.downcase)
      end
    end
    @items
  end

  # Adds an item to the Order's array of items
  def add_item(item)
    unless item.nil?
      @items.push(item.to_s.downcase)
    end
    @items
  end

  # Removes an item from the Order's array of items
  def delete_item(item)
    unless item.nil?
      @items.delete(item.to_s.downcase)
    end
    @items
  end

  # Returns a formatted string of the Order's Id, Name, and Items
  def to_str
    str = "Id: " + @id.to_s + "\nName: " + @name.to_s + "\nItem(s): \n"
    @items.each do |item|
      str += ">" + item.to_s + " \n"
    end
    str
  end

  # Comparison operator for equality between two Orders
  def ==(order)
    @id.to_s.downcase == order.get_id.to_s.downcase && @name.to_s.downcase == order.get_name.to_s.downcase
  end

  # Comparison operator for equality between two Orders
  def eql?(order)
    @id.to_s.downcase == order.get_id.to_s.downcase && @name.to_s.downcase == order.get_name.to_s.downcase
  end

end
