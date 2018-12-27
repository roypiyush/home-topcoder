from enum import Enum
from termcolor import colored


class Color(Enum):
    WHITE = 1
    GRAY = 2
    BLACK = 3


class Vertex:

    def __init__(self, key):
        self.color = Color.WHITE
        self.key = key
        self.adj_list = []
        self.distance = None
        self.parent = None
        self.start_time = None
        self.end_time = None

    def __str__(self):
        return "Key={} Color={} D={} st={} et={}".format(self.key, self.color,
                                                         self.distance, self.start_time, self.end_time)


class Graph:
    def __init__(self, vertices):
        """
        Dictionary of vertices

        :param vertices: dict
        """
        if type(vertices) != dict:
            raise TypeError(colored("Graph expected to be dictionary of vertices", 'blue'))
        self.vertices = vertices
        self.time = 0

    def breath_first_search(self, start_key):
        queue = []
        vertex = self.vertices[start_key]

        vertex.distance = 0
        queue.append(vertex)
        while len(queue) != 0:
            v = queue.pop(0)
            print(colored("Traversing {}".format(v), 'green'))

            if v.color == Color.WHITE:
                v.color = Color.GRAY
                for u in v.adj_list:
                    queue.append(u)
                    u.parent = v
                    u.distance = v.distance + 1
                    print(colored("{} ".format(u), 'magenta'))
            v.color = Color.BLACK

    def depth_first_search(self):
        for v in self.vertices.values():
            if v.color == Color.WHITE:
                self.__depth_first_visit(v)

    def __depth_first_visit(self, vertex):
        self.time += 1
        vertex.start_time = self.time
        vertex.color = Color.GRAY
        for v in vertex.adj_list:
            if v.color == Color.WHITE:
                self.__depth_first_visit(v)
        self.time += 1
        vertex.end_time = self.time
        vertex.color = Color.BLACK

    def print_vertices(self):
        for v in self.vertices.values():
            print(v)


def __main__():
    v1 = Vertex(1)
    v2 = Vertex(2)
    v3 = Vertex(3)
    v4 = Vertex(4)
    v5 = Vertex(5)
    v6 = Vertex(6)
    v7 = Vertex(7)
    v8 = Vertex(8)
    v9 = Vertex(9)
    v10 = Vertex(10)
    v1.adj_list = [v2, v3, v4]
    v2.adj_list = [v5, v6]
    v3.adj_list = [v7, v8]
    v4.adj_list = [v9, v10]
    v6.adj_list = [v9]
    v7.adj_list = [v10]
    vertices = dict({1: v1, 2: v2, 3: v3, 4: v4, 5: v5, 6: v6, 7: v7, 8: v8, 9: v9, 10: v10})
    graph = Graph(vertices)
    graph.breath_first_search(1)
    for v in vertices.values():
        v.color = Color.WHITE
    graph.depth_first_search()
    graph.print_vertices()


if __name__ == '__main__':
    __main__()
