void drawit(){
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
void strip1(int i){
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
      strokeWeight(3.5);
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
void strip2(int i){
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
      strokeWeight(3.5);
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
void drawit(PGraphics hard){
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
void strip11(int i, PGraphics hard){
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
void strip21(int i, PGraphics hard){
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
