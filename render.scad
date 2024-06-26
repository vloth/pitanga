$fn = 100;
use <lib/threads-scad/threads.scad>
union () {
  translate ([0, 0, -0.30999999999999994]) {
    rotate_extrude (angle=360) {
      polygon (points=[[0, 0], [3, 0], [1.75, 1], [0, 1]]);
    }
  }
  translate ([0, 0, -5.359999999999999]) {
    difference () {
      translate ([0, 0, -5.05]) {
        ScrewThread(6, 10.1);
      }
      translate ([0, 0, -3.9]) {
        linear_extrude (height=2.7, center=true){
          circle ($fn=6, r=3/2);
        }
      }
    }
  }
  sphere (r=1.59);
}
