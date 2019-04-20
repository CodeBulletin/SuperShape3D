public void on_offlights(){
  if(mxm == 0){
    mxm = 1;
  }
  else if(mxm == 1){
    mxm = 0;
  }
  setup();
}
public void BlackWhite(){
  rms = 1;
  if(gm == 1){
    rms1 = 1;
    gm = 0;
  }
  setup();
}
public void Colourfull(){
  rms = 2;
  mfs = 1;
  if(gm == 1){
    rms1 = 1;
    gm = 0;
  }
  setup();
}
public void colourOnly(){
  rms = 2;
  mfs = 0;
  if(gm == 1){
    rms1 = 1;
    gm = 0;
  }
  setup();
}
public void mesh_only(){
  rms = 3;
  if(rms1 == 1){
    gm = 1;
    rms1 = 0;
  }
  setup();
}
public void mesh_on_off(){
  if(rms != 3){
    if(rms1 == 0){
      rms1 = 1;
    }
    else if(rms1 == 1){
      rms1 = 0;
    }
  }
  if(rms == 3){
    gm = 1;
  }
}

public void Save_it(){
  main = extracter();
  ggg = integer();
  save(main);
  ++ggg;
  iiii = '0';
  writer(ggg);
}
public String objrec(){
  mainn = extracterobj();
  gggg = integerobj();
  revelo = mainn;
  ++gggg;
  writerobj(gggg);
  iiii = '0';
  return revelo;
}
public void radiusfactor(){
  if(rmm == 0){
    rmm = 1;
    dec = gsoc;
  }
  else if(rmm == 1){
    rmm = 0;
    dec = 0;
  }
  if(rms1 == 1){
    gm = 1;
    rms1 = 0;
  }
  setup();
}
public void Example(){
  if(ui3d == 0){
    ui3d = 1;
  }
  else if(ui3d == 1){
    ui3d = 0;
  }
  setup();
}
public void Toroid(){
  if(zx == 0){
    zx = 1;
    an3 = 0; an4 = TWO_PI;
    r = 200;
    a1 = 0.5;
    setup();
  }
  else if(zx == 1){
    zx = 0;
    an3 = -HALF_PI; an4 = HALF_PI;
    m1 = 0;
    a1 = 1;
    r = 300;
    setup();
  }
}
public void PlotForm(){
  if(mxr == 0){
    mxr = 1;
    rmss = rms;
    rmss1 = rms1;
    gm1 = gm;
    mfs1 = mfs;
    mxm1 = mxm;
    rms = rms1 = gm = mfs = mxm = 0;
    setup();
  }
  else if(mxr == 1){
    mxr = 0;
    rms = rmss;
    rms1 = rmss1;
    gm = gm1;
    mfs = mfs1;
    mxm = mxm1;
    setup();
  }
}
public void ChangeStrip(){
  if(lolo == 1){
    lolo = 0;
  }
  else if(lolo == 0){
    lolo = 1;
  }
}
public void StipsOn_Off(){
  if(rmbd == 1){
    rmbd = 0;
  }
  else if(rmbd == 0){
    rmbd = 1;
  }
}
public void Animate(){
  if(av == 0){
    av = 1;
    vam = 235;
    setup();
  }
  else if(av == 1){
    av = 0;
    vam = 0;
    setup();
  }
}
public void SaveOBJ(){
  saveobj = 1;
}
public void OneColor(){
  rms = 4;
  if(gm == 1){
    rms1 = 1;
    gm = 0;
  }
  setup();
}
public void reset(){
  if(zx == 0){
    m = 0;
    m1 = 0;
    n1 = 1;
    n2 = 1;
    n3 = 1;
    n11 = 1;
    n21 = 1;
    n31 = 1;
    a = 1;
    a1 = 1;
    b = 1;
    b1 = 1;
    depth = 100;
    r = 300;
    rms = 2;
    rms1 = 0;
    gm = 0;
    mxm = 1;
    mxr = 0;
    rmbd = 0;
    lolo = 0;
    AXM1 = 0.01;
    AXXM = 0.01;
    RAXM = 5;
    RAM1 = 5;
    afset = 0;
    ofset = 0;
    aafset = 0;
    oofset = 0;
    setup();
  }
  else if(zx == 1){
    m = 0;
    m1 = 0;
    n1 = 1;
    n2 = 1;
    n3 = 1;
    n11 = 1;
    n21 = 1;
    n31 = 1;
    a = 1;
    a1 = 0.5;
    b = 1;
    b1 = 1;
    depth = 100;
    r = 200;
    rms = 2;
    rms1 = 0;
    gm = 0;
    mxm = 1;
    mxr = 0;
    rmbd = 0;
    lolo = 0;
    AXM1 = 0.01;
    AXXM = 0.01;
    RAXM = 5;
    RAM1 = 5;
    afset = 0;
    ofset = 0;
    aafset = 0;
    oofset = 0;
    setup();
  }
}
void EXIT(){
  exit();
}
