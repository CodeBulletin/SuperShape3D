void shapeit(){
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
