import nervoussystem.obj.*;
import controlP5.*;
import peasy.*;

void setup(){
  fullScreen(OPENGL);
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
void draw(){
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
int pingg(){
  mono = createFont("Arial",16,true);
  textFont(mono);
  soc++;
  rpoc = cheaksize();
  return soc;
}
void mousePressed(){
  tanxx = 0;
}
