from manimlib.imports import *

class SumVisualize(Scene):
    def construct(self):
        watermark = TextMobject("Samuel Laberge")
        watermark.scale(0.4)
        watermark.to_corner(DOWN + RIGHT, buff = 0.1)
        self.add(watermark)
        N = 7
        squares = []
        for row in range(1, N):
            this_row = []
            for col in range(1, row+1):
                square = Square(side_length=1, color=BLUE)
                square.move_to([-6 + col, 4 - row, 0])
                this_row.append(square)
            self.play(*[Write(s) for s in this_row], run_time=0.25)
            squares.extend(this_row)

        group = VGroup(*squares)
        brace = Brace(group, LEFT)
        brace_text = brace.get_text("N")
        self.add(brace, brace_text)
        self.play(GrowFromCenter(brace), Write(brace_text))

        blue_area = TexMobject(r"A_{\text{blue}} = 1 + 2 + 3 + ... + N", color=BLUE)
        blue_area.move_to([3, 2, 0])
        self.play(Write(blue_area))
        self.wait(2)

        self.play(FadeOutAndShift(blue_area))

        square_group = VGroup(*squares)
        group_copy = square_group.copy()
        group_copy.set_color(RED)
        rotate = Rotate(group_copy, angle=math.radians(180), about_point=group_copy.get_center())
        translate = ApplyMethod(group_copy.shift, [1.03, 0.03, 0])
        self.play(rotate)
        self.play(translate)

        all_squares = group_copy.add(square_group)
        bottom_brace = Brace(all_squares, DOWN)
        bottom_brace_text = bottom_brace.get_text("N + 1")
        self.add(bottom_brace, bottom_brace_text)
        self.play(GrowFromCenter(bottom_brace), Write(bottom_brace_text))
        self.wait()

        all_area = TexMobject(r"A_{\text{total}} = N \times (N + 1)")
        all_area.move_to([4, 3, 0])
        self.play(Write(all_area))
        self.wait()

        blue_area1 = TexMobject(r"A_{\text{blue}} = \frac{A_{all}}{2}", color=BLUE)
        blue_area2 = TexMobject(r"= \frac{N\times(N+1)}{2}", color=BLUE)
        blue_area1.move_to([4, 1.5, 0])
        blue_area2.move_to([4, 0, 0])

        box = Rectangle(width=4, height=1.75)
        box.move_to(blue_area2.get_center())

        self.play(Write(blue_area1))
        self.play(Write(blue_area2))
        self.wait(0.5)
        self.play(Write(box))
        self.wait(3)
