$fn = 100;
use <lib/threads-scad/threads.scad>
union () {
  sphere (r=17);
  translate ([16.530155, 0.0, -8.500000000000002]) {
    rotate ([0.0,-59.99999999999999,0.0]) {
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
    }
  }
  translate ([-8.265077500000004, 14.315534158494357, -8.500000000000002]) {
    rotate ([0.0,-59.99999999999999,120.00000000000001]) {
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
    }
  }
  translate ([-8.26507750000002, -14.315534158494346, -8.500000000000002]) {
    rotate ([0.0,-59.99999999999999,239.99999999999994]) {
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
    }
  }
}
