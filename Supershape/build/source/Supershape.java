import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import nervoussystem.obj.*; 
import controlP5.*; 
import peasy.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Supershape extends PApplet {





public void setup(){
  
  if(soc == 0){
    soc = pingg();
  }
  g3 = (PGraphics3D)g;
  cam = new PeasyCam(this,800);
  ui();
  colorMode(HSB);
  globe = new PVector[402][402];
  fill(255);
}
float mx = 0;
public void draw(){
  if((cheakxmin()||
      cheakxmax()||
      ((mouseY > height - 30)&&
      (mouseX > width - 185)))){
    cam.setMouseControlled(false);
  }
  else{
    cam.setMouseControlled(true);
  }
  noStroke();
  background(0);
  if(mxm == 1){
    lights();
  }
  background(0);
  shapeit();
  if(saveobj == 1){
    if(mxr == 0){
      OBJExport obj = (OBJExport) createGraphics(10,10,"nervoussystem.obj.OBJExport",objrec());
      obj.setColor(true);
      obj.beginDraw();
      drawit(obj);
      obj.endDraw();
      obj.dispose();
    }
    else{
      tanxx = 1;
    }
    saveobj = 0;
  }
  drawit();
  currCameraMatrix = new PMatrix3D(g3.camera);
  camera();
  MyController.draw();
  g3.camera = currCameraMatrix;
  ui20();
  if(mxr == 1 && (rms !=0 || rms1 == 1 || mxm == 1)){
    tanxx = 1;
    rms = rms1 = mxm = 0;
  }
  fill(255);
  if(tanxx == 1){
    text("Not Possible in Point form", width - 510, height - 25);
  }
  text("Created By Bhavesh Malhotra aka Code Bulletin", width - 510, height - 10);
  textSize(15);
  text("Options : ",15,15);
  if(rms == 4 && mxr == 0){
    text("color pallet :", width - 185, 20);
  }
  if(av == 1){
    text("Animation pallet :", width - 185, height - 210);
  }
}
public int pingg(){
  mono = createFont("Arial",16,true);
  textFont(mono);
  soc++;
  rpoc = cheaksize();
  return soc;
}
public void mousePressed(){
  tanxx = 0;
}
public float supershape(float theta, float a, float b, float m, float n1, float n2, float n3){
  float t1 = abs((1/a)*cos(m*theta/4));
  t1 = pow(t1, n2);
  float t2 = abs((1/b)*sin(m*theta/4));
  t2 = pow(t2, n3);
  float t3 = t1 + t2;
  float r = pow(t3, -1/n1);
  return r;
}
public boolean cheakxmin(){
  if(ui3d == 0){
    rops = 230;
  }
  else if(ui3d == 1){
    rops = 280;
  }
  if(mouseX < rops){
    return true;
  }
  else{
    return false;
  }
}
public boolean cheakxmax(){
  if((av == 0)&&(rms != 4)){
    return false;
  }
  else if((av == 1)||(rms == 4)){
    rops = width - 220;
  }
  if(mouseX > rops){
    return true;
  }
  else{
    return false;
  }
}
public int cheaksize(){
  if(height > 767){
    rpoc = 0;
    gsoc = 40;
  }
  else if(height < 768){
    rpoc = 15;
    gsoc = 25;
  }
  return rpoc;
}
public void sli(){
  createSlider("m",0,10,m,20,100,150,20,"m1");
  createSlider("n1",-150,150,n1,20,140-rpoc,150,20,"n11");
  createSlider("n2",-150,150,n2,20,180-2*rpoc,150,20,"n12");
  createSlider("n3",-150,150,n3,20,220-3*rpoc,150,20,"n13");
  createSlider("m1",0,10,m1,20,260-4*rpoc,150,20,"m2");
  createSlider("n11",-150,150,n11,20,300-5*rpoc,150,20,"n21");
  createSlider("n21",-150,150,n21,20,340-6*rpoc,150,20,"n22");
  createSlider("n31",-150,150,n31,20,380-7*rpoc,150,20,"n23");
  createSlider("a",0.1f,5,a,20,420-8*rpoc,150,20,"a1");
  createSlider("b",0.1f,5,b,20,460-9*rpoc,150,20,"b1");
  createSlider("a1",0.1f,5,a1,20,500-10*rpoc,150,20,"a2");
  createSlider("b1",0.1f,5,b1,20,540-11*rpoc,150,20,"b2");
  createSlider("depth",20,400,depth,20,580-12*rpoc,150,20,"Quality");
  cheaksum();
}
public void cheaksum(){
  if(rmm == 0){
    createSlider("r",100,600,r,20,620-13*rpoc,150,20,"radius");
  }
  if(av == 1){
    createSliderlon("AXXM",0,1,AXXM,width-210,height - 200,25,150,"ASM1");
    createSliderlon("AXM1",0,1,AXM1,width-155,height - 200,25,150,"ASM2");
    createSliderlon("RAXM",0,10,RAXM,width-100,height - 200,25,150,"RM1");
    createSliderlon("RAM1",0,10,RAM1,width-45,height - 200,25,150,"RM2");
  }
  if((rms == 4)&&(mxr == 0)){
    createSliderlon("H",0,255,H,width-176,30,20,255,"H");
    createSliderlon("S",0,255,S,width-111,30,20,255,"S");
    createSliderlon("B",0,255,B,width-41,30,20,255,"B");
  }
}
public void createSlider(String nameofs, float minVal, float maxVal, float defVal, int sxcords, int sycords, int sxsize, int sysize, String namesws){
  Slider slide = MyController.addSlider(nameofs, minVal, maxVal, defVal, sxcords, sycords, sxsize, sysize);
  slide.setCaptionLabel(namesws);
}
public void createSliderlon(String nameof, float minVal, float maxVal, float defVal, int sxcords, int sycords, int sxsize, int sysize, String namesws){
  Slider slide = MyController.addSlider(nameof, minVal, maxVal, defVal, sxcords, sycords, sxsize, sysize);
  slide.setCaptionLabel(namesws);
}
public void shapeit(){
  if((rmm == 0)&&(zx == 0)&&(av == 0)){
    for(int i = 0; i < depth+1; i++){
      float lat = map(i , 0 , depth , an3, an4);
      float r2 = supershape(lat, a1, b1, m1, n11, n21, n31);
      for(int j = 0; j < depth+1; j++){
        float lon = map(j , 0 , depth , an1 , an2);
        float r1 = supershape(lon, a, b, m, n1, n2, n3);
        float x = r * r1 * cos(lon) * r2 * cos(lat);
        float y = r * r1 * sin(lon) * r2 * cos(lat);
        float z = r * r2 * sin(lat);
        globe[i][j] = new PVector(x , y , z);
      }
    }
  }
  if((rmm == 0)&&(zx == 0)&&(av == 1)){
    afset += AXXM;
    ofset = abs(RAXM*sin(afset));
    aafset += AXM1;
    oofset = abs(RAM1*sin(aafset));
    for(int i = 0; i < depth+1; i++){
      float lat = map(i , 0 , depth , an3, an4);
      float r2 = supershape(lat, a1, b1, m1+oofset, n11, n21, n31);
      for(int j = 0; j < depth+1; j++){
        float lon = map(j , 0 , depth , an1 , an2);
        float r1 = supershape(lon, a, b, m+ofset, n1, n2, n3);
        float x = r * r1 * cos(lon) * r2 * cos(lat);
        float y = r * r1 * sin(lon) * r2 * cos(lat);
        float z = r * r2 * sin(lat);
        globe[i][j] = new PVector(x , y , z);
      }
    }
  }
  else if((rmm == 1)&&(zx == 0)&&(av == 0)){
    for(int i = 0; i < depth+1; i++){
      float lat = map(i , 0 , depth , an3, an4);
      float r2 = supershape(lat, a1, b1, m1, n11, n21, n31);
      for(int j = 0; j < depth+1; j++){
        float lon = map(j , 0 , depth , an1 , an2);
        float r1 = supershape(lon, a, b, m, n1, n2, n3);
        float x = 100 * r1 * cos(lon) * r2 * cos(lat);
        float y = 100 * r1 * sin(lon) * r2 * cos(lat);
        float z = 100 * r2 * sin(lat);
        globe[i][j] = new PVector(x , y , z);
      }
    }
  }
  else if((rmm == 1)&&(zx == 0)&&(av == 1)){
    afset += AXXM;
    ofset = abs(RAXM*sin(afset));
    aafset += AXM1;
    oofset = abs(RAM1*sin(aafset));
    for(int i = 0; i < depth+1; i++){
      float lat = map(i , 0 , depth , an3, an4);
      float r2 = supershape(lat, a1, b1, m1+oofset, n11, n21, n31);
      for(int j = 0; j < depth+1; j++){
        float lon = map(j , 0 , depth , an1 , an2);
        float r1 = supershape(lon, a, b, m+ofset, n1, n2, n3);
        float x = 100 * r1 * cos(lon) * r2 * cos(lat);
        float y = 100 * r1 * sin(lon) * r2 * cos(lat);
        float z = 100 * r2 * sin(lat);
        globe[i][j] = new PVector(x , y , z);
      }
    }
  }
  else if((zx == 1)&&(av ==0)&&(rmm == 0)){
    for(int i = 0; i < depth+1; i++){
      float lat = map(i , 0 , depth , an3, an4);
      float r2 = supershape(lat, a1, b1, m1, n11, n21, n31);
      for(int j = 0; j < depth+1; j++){
        float lon = map(j , 0 , depth , an1 , an2);
        float r1 = supershape(lon, a, b, m, n1, n2, n3);
        float x = r * cos(lon)*(r1 +(r2*cos(lat)));
        float y = r * sin(lon)*(r1 +(r2*cos(lat)));
        float z = r * r2 * sin(lat);
        globe[i][j] = new PVector(x , y , z);
      }
    }
  }
  else if((zx == 1)&&(av == 1)&&(rmm == 0)){
    afset += AXXM;
    ofset = abs(RAXM*sin(afset));
    aafset += AXM1;
    oofset = abs(RAM1*sin(aafset));
    for(int i = 0; i < depth+1; i++){
      float lat = map(i , 0 , depth , an3, an4);
      float r2 = supershape(lat, a1, b1, m1+oofset, n11, n21, n31);
      for(int j = 0; j < depth+1; j++){
        float lon = map(j , 0 , depth , an1 , an2);
        float r1 = supershape(lon, a, b, m+ofset, n1, n2, n3);
        float x = r * cos(lon)*(r1 +(r2*cos(lat)));
        float y = r * sin(lon)*(r1 +(r2*cos(lat)));
        float z = r * r2 * sin(lat);
        globe[i][j] = new PVector(x , y , z);
      }
    }
  }
  else if((zx == 1)&&(av == 0)&&(rmm == 1)){
    for(int i = 0; i < depth+1; i++){
      float lat = map(i , 0 , depth , an3, an4);
      float r2 = supershape(lat, a1, b1, m1, n11, n21, n31);
      for(int j = 0; j < depth+1; j++){
        float lon = map(j , 0 , depth , an1 , an2);
        float r1 = supershape(lon, a, b, m, n1, n2, n3);
        float x = 100 * cos(lon)*(r1 +(r2*cos(lat)));
        float y = 100 * sin(lon)*(r1 +(r2*cos(lat)));
        float z = 100 * r2 * sin(lat);
        globe[i][j] = new PVector(x , y , z);
      }
    }
  }
  else if((zx == 1)&&(av == 1)&&(rmm == 1)){
    afset += AXXM;
    ofset = abs(RAXM*sin(afset));
    aafset += AXM1;
    oofset = abs(RAM1*sin(aafset));
    for(int i = 0; i < depth+1; i++){
      float lat = map(i , 0 , depth , an3, an4);
      float r2 = supershape(lat, a1, b1, m1+oofset, n11, n21, n31);
      for(int j = 0; j < depth+1; j++){
        float lon = map(j , 0 , depth , an1 , an2);
        float r1 = supershape(lon, a, b, m+ofset, n1, n2, n3);
        float x = r * cos(lon)*(r1 +(r2*cos(lat)));
        float y = r * sin(lon)*(r1 +(r2*cos(lat)));
        float z = r * r2 * sin(lat);
        globe[i][j] = new PVector(x , y , z);
      }
    }
  }
}
public void drawit(){
    if(mfs == 0){
      offset += 0;
    }
    else if(mfs == 1){
      offset += 5;
    }
    for(int i = 0; i < depth; i++){
      if(rms == 1){
        if(i%2==0){
          fill(255);
        }
        else{
          fill(50);
        }
      }
      if(rms == 2){
        float hu = map(i , 0 , 255 , 0 , 255*20);
        fill((hu+offset)%255, 255, 255);
      }
      if (rms == 3){
        stroke(255);
        noFill();
      }
      if(rms == 4){
        fill(H, S, B);
      }
      if (rms1 == 1){
        stroke(150);
      }
      if(lolo == 0){
        strip1(i);
      }
      else if(lolo == 1){
        strip2(i);
      }
    }
}
public void strip1(int i){
  if(mxr == 0){
    beginShape(TRIANGLE_STRIP);
    for(int j = 0; j < depth+1; j++){
      PVector v1 = globe[i][j];
      vertex(v1.x , v1.y , v1.z);
      PVector v2 = globe[i+1][j];
      vertex(v2.x , v2.y , v2.z);
    }
    endShape();
  }
  else if((mxr == 1)&&(rmbd == 0)){
    push();
    for(int j = 0; j < depth+1; j++){
      stroke(200);
      strokeWeight(3.5f);
      PVector v1 = globe[i][j];
      point(v1.x , v1.y , v1.z);
    }
    pop();
  }
  else if((mxr == 1)&&(rmbd == 1)){
    push();
    beginShape(LINE_STRIP);
    for(int j = 0; j < depth+1; j++){
      stroke(200);
      strokeWeight(1);
      PVector v1 = globe[i][j];
      vertex(v1.x , v1.y , v1.z);
    }
    endShape();
    pop();
  }
}
public void strip2(int i){
  if(mxr == 0){
    beginShape(TRIANGLE_STRIP);
    for(int j = 0; j < depth+1; j++){
      PVector v1 = globe[j][i];
      vertex(v1.x , v1.y , v1.z);
      PVector v2 = globe[j][i+1];
      vertex(v2.x , v2.y , v2.z);
    }
    endShape();
  }
  else if((mxr == 1)&&(rmbd == 0)){
    push();
    for(int j = 0; j < depth+1; j++){
      stroke(200);
      strokeWeight(3.5f);
      PVector v1 = globe[i][j];
      point(v1.x , v1.y , v1.z);
    }
    pop();
  }
  else if((mxr == 1)&&(rmbd == 1)){
    push();
    beginShape(LINE_STRIP);
    for(int j = 0; j < depth+1; j++){
      stroke(200);
      strokeWeight(1);
      PVector v1 = globe[j][i];
      vertex(v1.x , v1.y , v1.z);
    }
    endShape();
    pop();
  }
}
public void drawit(PGraphics hard){
  hard.colorMode(HSB);
  if(mfs == 0){
    offset += 0;
  }
  else if(mfs == 1){
    offset += 5;
  }
  for(int i = 0; i < depth; i++){
    if(rms == 1){
      if(i%2==0){
        hard.fill(255);
      }
      else{
        hard.fill(50);
      }
    }
    if(rms == 2){
      float hu = map(i , 0 , 255 , 0 , 255*20);
      hard.fill((hu+offset)%255, 255, 255);
    }
    else if (rms == 3){
      hard.stroke(255);
      hard.noFill();
    }
    if(rms == 4){
      hard.fill(H, S, B);
    }
    if (rms1 == 1){
      hard.stroke(150);
    }
    if(lolo == 0){
      strip11(i, hard);
    }
    else if(lolo == 1){
      strip21(i, hard);
    }
  }
}
public void strip11(int i, PGraphics hard){
  if(mxr == 0){
    hard.beginShape(TRIANGLE_STRIP);
    for(int j = 0; j < depth+1; j++){
      PVector v1 = globe[i][j];
      hard.vertex(v1.x , v1.y , v1.z);
      PVector v2 = globe[i+1][j];
      hard.vertex(v2.x , v2.y , v2.z);
    }
    hard.endShape();
  }
}
public void strip21(int i, PGraphics hard){
  if(mxr == 0){
    hard.beginShape(TRIANGLE_STRIP);
    for(int j = 0; j < depth+1; j++){
      PVector v1 = globe[j][i];
      hard.vertex(v1.x , v1.y , v1.z);
      PVector v2 = globe[j][i+1];
      hard.vertex(v2.x , v2.y , v2.z);
    }
    hard.endShape();
  }
}
public void ui20(){
  if(mxr == 0){
    if(rms == 4){
      fill(255);
      for(int id = 0; id<256; id ++){
        stroke(255-id, S, B);
        for(int jd = 0; jd<10;jd++){
          point(width - 185 + jd, id + 30);
        }
      }
      for(int id = 0; id<256; id ++){
        stroke(H, 255 - id, B);
        for(int jd = 0; jd<10;jd++){
          point(width - 120 + jd, id + 30);
        }
      }
      for(int id = 0; id<256; id ++){
        stroke(0, 0,255 - id);
        for(int jd = 0; jd<10;jd++){
          point(width - 50 + jd, id + 30);
        }
      }
    }
  }
}
public void but(){
  createButton("colourOnly",10,20,20,80,20,"Color full");
  createButton("on_offlights",10,20,45,80,20,"Ligthts");
  createButton("BlackWhite",10,20,70,80,20,"Black and white");
  createButton("Colourfull",10,105,20,80,20,"Animate Color");
  createButton("OneColor",10,105,45,80,20,"Single Color mode");
  createButton("mesh_on_off",10,105,70,80,20,"Activate mesh");
  createButton("reset",10,20,645-dec-13*rpoc,80,20,"Reset");
  createButton("Save_it",10,105,645-dec-13*rpoc,80,20,"Save Image");
  createButton("radiusfactor",10,20,670-dec-13*rpoc,80,20,"Set radius to 100");
  createButton("Example",10,105,670-dec-13*rpoc,80,20,"Examples");
  createButton("Toroid",10,20,695-dec-13*rpoc,80,20,"Toroid symmetry");
  createButton("PlotForm",10,105,695-dec-13*rpoc,80,20,"Point form");
  createButton("Animate",10,20,720-dec-13*rpoc,80,20,"Animation mode");
  createButton("ChangeStrip",10,60,745-dec-13*rpoc,80,20,"Change Stripe");
  createButton("SaveOBJ",10,width-180,height-25,80,20,"Save as OBJ");
  createButton("EXIT",10,width-90,height-25,80,20,"Exit");
  if(mxr == 1){
    createButton("StipsOn_Off",10,105,720-dec-13*rpoc,80,20,"Strip Mode");
  }
  else if(mxr == 0){
    createButton("mesh_only",10,105,720-dec-13*rpoc,80,20,"Mesh only mode");
  }
  if(ui3d == 1){
    if(zx == 1 && av == 0){
      but1();
    }
    if(zx == 0 && av == 0){
      but2();
    }
    if(zx == 1 && av == 1){
      butA1();
    }
    if(zx == 0 && av == 1){
      butA2();
    }
  }
}
public void but1(){
  createButton("TExample1",10,190,20,80,20,"Example 1");
  createButton("TExample2",10,190,45,80,20,"Example 2");
  createButton("TExample3",10,190,70,80,20,"Example 3");
  createButton("TExample4",10,190,95,80,20,"Example 4");
  createButton("TExample5",10,190,120,80,20,"Example 5");
  createButton("TExample6",10,190,145,80,20,"Example 6");
  createButton("TExample7",10,190,170,80,20,"Example 7");
  createButton("TExample8",10,190,195,80,20,"Example 8");
  createButton("TExample9",10,190,220,80,20,"Example 9");
  createButton("TExample10",10,190,245,80,20,"Example 10");
}
public void but2(){
  createButton("Example1",10,190,20,80,20,"Example 1");
  createButton("Example2",10,190,45,80,20,"Example 2");
  createButton("Example3",10,190,70,80,20,"Example 3");
  createButton("Example4",10,190,95,80,20,"Example 4");
  createButton("Example5",10,190,120,80,20,"Example 5");
  createButton("Example6",10,190,145,80,20,"Example 6");
  createButton("Example7",10,190,170,80,20,"Example 7");
  createButton("Example8",10,190,195,80,20,"Example 8");
  createButton("Example9",10,190,220,80,20,"Example 9");
  createButton("Example10",10,190,245,80,20,"Example 10");
}
public void butA1(){
  createButton("TAExample1",10,190,20,80,20,"Example 1");
  createButton("TAExample2",10,190,45,80,20,"Example 2");
  createButton("TAExample3",10,190,70,80,20,"Example 3");
  createButton("TAExample4",10,190,95,80,20,"Example 4");
  createButton("TAExample5",10,190,120,80,20,"Example 5");
  createButton("TAExample6",10,190,145,80,20,"Example 6");
  createButton("TAExample7",10,190,170,80,20,"Example 7");
  createButton("TAExample8",10,190,195,80,20,"Example 8");
  createButton("TAExample9",10,190,220,80,20,"Example 9");
  createButton("TAExample10",10,190,245,80,20,"Example 10");
}
public void butA2(){
  createButton("AExample1",10,190,20,80,20,"Example 1");
  createButton("AExample2",10,190,45,80,20,"Example 2");
  createButton("AExample3",10,190,70,80,20,"Example 3");
  createButton("AExample4",10,190,95,80,20,"Example 4");
  createButton("AExample5",10,190,120,80,20,"Example 5");
  createButton("AExample6",10,190,145,80,20,"Example 6");
  createButton("AExample7",10,190,170,80,20,"Example 7");
  createButton("AExample8",10,190,195,80,20,"Example 8");
  createButton("AExample9",10,190,220,80,20,"Example 9");
  createButton("AExample10",10,190,245,80,20,"Example 10");
}
public void createButton(String nameof,int vale,int xcord,int ycord,int xsize,int ysize ,String namesh){
  Button button = MyController.addButton(nameof, vale, xcord, ycord, xsize, ysize);
  button.setCaptionLabel(namesh);
}
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
    a1 = 0.5f;
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
    AXM1 = 0.01f;
    AXXM = 0.01f;
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
    a1 = 0.5f;
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
    AXM1 = 0.01f;
    AXXM = 0.01f;
    RAXM = 5;
    RAM1 = 5;
    afset = 0;
    ofset = 0;
    aafset = 0;
    oofset = 0;
    setup();
  }
}
public void EXIT(){
  exit();
}
private String extracter(){
  String[] s = loadStrings("/data/number.txt");
  String myfile = "/data/Images/colour";
  String filetype = ".png";
  String m = myfile + s[0] + filetype;
  return m;
}
private int integer(){
  String[] s = loadStrings("/data/number.txt");
  int n = PApplet.parseInt(s[0]);
  return n;
}
private void writer(int n){
  String m = str(n);
  String[] g = split(m, " ");
  saveStrings("/data/number.txt", g);
}
private String extracterobj(){
  String[] s = loadStrings("/data/numberobj.txt");
  String myfile = "/data/Objects/object";
  String filetype = ".obj";
  String myojfile = "/object";
  String m = myfile + s[0] + myojfile + s[0] + filetype;
  return m;
}
private int integerobj(){
  String[] s = loadStrings("/data/numberobj.txt");
  int n = PApplet.parseInt(s[0]);
  return n;
}
private void writerobj(int n){
  String m = str(n);
  String[] g = split(m, " ");
  saveStrings("/data/numberobj.txt", g);
}
public void ui(){
  MyController = new ControlP5(this);
  sli();
  but();
  MyController.setAutoDraw(false);
}
int vorks;
int rpoc;
int depth = 100;
float r = 300;
float a = 1;
float b = 1;
float n1 = 1;
float n2 = 1;
float n3 = 1;
float m = 0;
float a1 = 1;
float b1 = 1;
float n11 = 1;
float n21 = 1;
float n31 = 1;
float m1 = 0;
float offset = 0;
float an1 = -PI;
float an2 = PI;
float an3 = -HALF_PI;
float an4 = HALF_PI;
int mxm = 1;
int mfs = 0;
PVector[][] globe;
int rms = 2;
int rms1 = 0;
PeasyCam cam;
PMatrix3D currCameraMatrix;
PGraphics3D g3;
ControlP5 MyController;
int ON_OF = 0;
int gm = 0;
String main;
int ggg;
int iii;
String mainn;
int gggg;
int iiii;
int rmm = 0;
int dec = 0;
int ui3d = 0;
int zx = 0;
int av = 0;
float afset;
float ofset;
float AXM1 = 0.01f;
float AXXM = 0.01f;
float RAXM = 5;
float RAM1 = 5;
float aafset;
float oofset;
int mxr = 0;
int rmss,rmss1,gm1,mfs1,mxm1;
int lolo=0;
int rmbd=0;
int soc;
int saveobj = 0;
String revelo;
PFont mono;
int vam = 0;
int tanxx = 0;
int OC1;
int VAM;
int H = 125, S = 125 ,B = 125;
int gsoc;
int rops;
public void Example1(){
  m = 2; n1 = 0.7f; n2 = 0.3f; n3 = 0.2f;
  m1 = 3; n11 = 100; n21 = 100; n31 = 100;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void Example2(){
  m = 7; n1 = 0.2f; n2 = 1.7f; n3 = 1.7f;
  m1 = 7; n11 = 0.2f; n21 = 1.7f; n31 = 1.7f;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void Example3(){
  m = 6; n1 = 1; n2 = 1; n3 = 1;
  m1 = 3; n11 = 1; n21 = 1; n31 = 1;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void Example4(){
  m = 5; n1 = 0.1f; n2 = 1.7f; n3 = 1.7f;
  m1 = 1; n11 = 0.3f; n21 = 0.5f; n31 = 0.5f;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void Example5(){
  m = 6; n1 = 0.24f; n2 = 47.81f; n3 = -0.86f;
  m1 = 7; n11 = -76.88f; n21 = 0.52f; n31 = -56.7f;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void Example6(){
  m = 3; n1 = 260; n2 = 500; n3 = 500;
  m1 = 4; n11 = 200; n21 = 200; n31 = 200;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void Example7(){
  m = 4; n1 = 100; n2 = 100; n3 = 100;
  m1 = 4; n11 = 100; n21 = 100; n31 = 100;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void Example8(){
  m = 2; n1 = 0.99f; n2 = 97.67f; n3 = -0.43f;
  m1 = 7; n11 = -8.11f; n21 = -0.08f; n31 = 93;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void Example9(){
  m = 1;n1 = 37.41f; n2 = -0.24f; n3 = 19.07f;
  m1 = 4; n11 = 100; n21 = 100; n31 = 100;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void Example10(){
  m = 6; n1 = -0.47f; n2 = 1.61f; n3 = 0.87f;
  m1 = 0; n11 = 1; n21 = 1; n31 = 1;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void AExample1(){
  m = 2; n1 = 0.7f; n2 = 0.3f; n3 = 0.2f;
  m1 = 3; n11 = 100; n21 = 100; n31 = 100;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void AExample2(){
  m = 7; n1 = 0.2f; n2 = 1.7f; n3 = 1.7f;
  m1 = 7; n11 = 0.2f; n21 = 1.7f; n31 = 1.7f;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void AExample3(){
  m = 6; n1 = 1; n2 = 1; n3 = 1;
  m1 = 3; n11 = 1; n21 = 1; n31 = 1;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void AExample4(){
  m = 5; n1 = 0.1f; n2 = 1.7f; n3 = 1.7f;
  m1 = 1; n11 = 0.3f; n21 = 0.5f; n31 = 0.5f;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void AExample5(){
  m = 6; n1 = 0.24f; n2 = 47.81f; n3 = -0.86f;
  m1 = 7; n11 = -76.88f; n21 = 0.52f; n31 = -56.7f;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void AExample6(){
  m = 3; n1 = 260; n2 = 500; n3 = 500;
  m1 = 4; n11 = 200; n21 = 200; n31 = 200;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void AExample7(){
  m = 4; n1 = 100; n2 = 100; n3 = 100;
  m1 = 4; n11 = 100; n21 = 100; n31 = 100;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void AExample8(){
  m = 2; n1 = 0.99f; n2 = 97.67f; n3 = -0.43f;
  m1 = 7; n11 = -8.11f; n21 = -0.08f; n31 = 93;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void AExample9(){
  m = 1;n1 = 37.41f; n2 = -0.24f; n3 = 19.07f;
  m1 = 4; n11 = 100; n21 = 100; n31 = 100;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void AExample10(){
  m = 6; n1 = -0.47f; n2 = 1.61f; n3 = 0.87f;
  m1 = 0; n11 = 1; n21 = 1; n31 = 1;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void TExample1(){
  m = 6; n1 = 1; n2 = 1; n3 = 1;
  m1 = 4; n11 = 1; n21 = 1; n31 = 1;
  a = 1; b = 1; a1 = 0.5f; b1 =1;
  setup();
}
public void TExample2(){
  m = 10; n1 = 2; n2 = 0; n3 = 20.66f;
  m1 = 2; n11 = 0.66f; n21 = 0; n31 = 1.33f;
  a = 1; b = 1; a1 = 0.5f; b1 =1;
  setup();
}
public void TExample3(){
  m = 10; n1 = 1; n2 = 1; n3 = 1;
  m1 = 10; n11 = 0.66f; n21 = 1; n31 = 1;
  a = 1; b = 1; a1 = 0.5f; b1 =1;
  setup();
}
public void TExample4(){
  m = 10; n1 = -0.92f; n2 = 67.72f; n3 = 0.12f;
  m1 = 10; n11 = -98.04f; n21 = 0.06f; n31 = -45.52f;
  a = 1.51f; b =1.67f; a1 = 1.30f; b1 =0.29f;
  setup();
}
public void TExample5(){
  m = 4; n1 = 150; n2 = 150; n3 = 150;
  m1 = 4; n11 = 150; n21 = 150; n31 = 150;
  a = 1; b = 1; a1 = 0.5f; b1 =1;
  setup();
}
public void TExample6(){
  m = 4; n1 = 150; n2 = 0; n3 = 150;
  m1 = 4; n11 = 150; n21 = -150; n31 = 150;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void TExample7(){
  m = 4; m1 = 4;
  n1 = -46; n11 = 22;
  n2 = -22; n21 = -26;
  n3 = 150; n31 = 150;
  a = 1; b = 1; a1 = 1; b1 =1;
  setup();
}
public void TExample8(){
  m = 4; m1 = 4;
  n1 = -46; n11 = 22;
  n2 = -22; n21 = -26;
  n3 = 150; n31 = 150;
  a = 0.10f; b = 1; a1 = 1; b1 =1;
  setup();
}
public void TExample9(){
  m = 4; m1 = 4;
  n1 = -150; n11 = 22;
  n2 = -150; n21 = -26;
  n3 = -150; n31 = 150;
  a = 0.5f; b = 1; a1 = 1; b1 =1;
  setup();
}
public void TExample10(){
  m = 10; m1 = 1;
  n1 = -150; n11 = 22;
  n2 = -150; n21 = -26;
  n3 = -150; n31 = 150;
  a = 0.5f; b = 1; a1 = 1; b1 =1;
  setup();
}
public void TAExample1(){
  m = 6; n1 = 1; n2 = 1; n3 = 1;
  m1 = 4; n11 = 1; n21 = 1; n31 = 1;
  a = 1; b = 1; a1 = 0.5f; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void TAExample2(){
  m = 10; n1 = 2; n2 = 0; n3 = 20.66f;
  m1 = 2; n11 = 0.66f; n21 = 0; n31 = 1.33f;
  a = 1; b = 1; a1 = 0.5f; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void TAExample3(){
  m = 10; n1 = 1; n2 = 1; n3 = 1;
  m1 = 10; n11 = 0.66f; n21 = 1; n31 = 1;
  a = 1; b = 1; a1 = 0.5f; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void TAExample4(){
  m = 10; n1 = -0.92f; n2 = 67.72f; n3 = 0.12f;
  m1 = 10; n11 = -98.04f; n21 = 0.06f; n31 = -45.52f;
  a = 1.51f; b =1.67f; a1 = 1.30f; b1 =0.29f;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void TAExample5(){
  m = 4; n1 = 150; n2 = 150; n3 = 150;
  m1 = 4; n11 = 150; n21 = 150; n31 = 150;
  a = 1; b = 1; a1 = 0.5f; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void TAExample6(){
  m = 4; n1 = 150; n2 = 0; n3 = 150;
  m1 = 4; n11 = 150; n21 = -150; n31 = 150;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void TAExample7(){
  m = 4; m1 = 4;
  n1 = -46; n11 = 22;
  n2 = -22; n21 = -26;
  n3 = 150; n31 = 150;
  a = 1; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void TAExample8(){
  m = 4; m1 = 4;
  n1 = -46; n11 = 22;
  n2 = -22; n21 = -26;
  n3 = 150; n31 = 150;
  a = 0.10f; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void TAExample9(){
  m = 4; m1 = 4;
  n1 = -150; n11 = 22;
  n2 = -150; n21 = -26;
  n3 = -150; n31 = 150;
  a = 0.5f; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
public void TAExample10(){
  m = 10; m1 = 1;
  n1 = -150; n11 = 22;
  n2 = -150; n21 = -26;
  n3 = -150; n31 = 150;
  a = 0.5f; b = 1; a1 = 1; b1 =1;
  AXM1 = 0.01f;
  AXXM = 0.01f;
  RAXM = 5;
  RAM1 = 5;
  afset = 0;
  ofset = 0;
  aafset = 0;
  oofset = 0;
  setup();
}
  public void settings() {  fullScreen(OPENGL); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Supershape" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
