# Base class
class Shape:
    def __init__(self, color="Black"):
        self.color = color

    def area(self):
        return 0  # Default implementation

    def display(self):
        print(f"Shape color: {self.color}")

# Derived class - Circle
class Circle(Shape):
    def __init__(self, radius, color="Black"):
        super().__init__(color)  # Inheriting constructor
        self.radius = radius

    # Method Overriding
    def area(self):
        return 3.14 * self.radius ** 2

    def display(self):
        print(f"Circle with radius {self.radius}, Color: {self.color}, Area: {self.area()}")

# Derived class - Rectangle
class Rectangle(Shape):
    # Method Overloading via default arguments
    def __init__(self, length, width=None, color="Black"):
        super().__init__(color)
        if width is None:
            width = length  # Treat as square if width not given
        self.length = length
        self.width = width

    # Method Overriding
    def area(self):
        return self.length * self.width

    def display(self):
        print(f"Rectangle {self.length}x{self.width}, Color: {self.color}, Area: {self.area()}")


shape = Shape("Blue")
shape.display()

circle = Circle(5, "Red")
circle.display()

rect = Rectangle(4, 6, "Green")
rect.display()

square = Rectangle(4, color="Yellow")  # overloaded constructor for square
square.display()


