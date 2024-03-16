$fn = 100;
color ([0, 0.5, 0.255, ]) {
  translate ([0, 18.5, 0]) {
    linear_extrude (height=2, center=true){
      circle (r=1.6);
    }
  }
}
color ([0, 0.5, 0.255, ]) {
  translate ([0, -18.5, 0]) {
    linear_extrude (height=2, center=true){
      circle (r=1.6);
    }
  }
}
color ([0.255, 0, 0, 0.4]) {
  difference () {
    import ("svg/sensor-board-outline.svg", center=true);
    import ("svg/sensor-mount.svg", center=true);
    import ("svg/sensor-pmw.svg", center=true);
  }
}
