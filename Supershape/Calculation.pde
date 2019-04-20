float supershape(float theta, float a, float b, float m, float n1, float n2, float n3){
  float t1 = abs((1/a)*cos(m*theta/4));
  t1 = pow(t1, n2);
  float t2 = abs((1/b)*sin(m*theta/4));
  t2 = pow(t2, n3);
  float t3 = t1 + t2;
  float r = pow(t3, -1/n1);
  return r;
}
