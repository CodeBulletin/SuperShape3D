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
