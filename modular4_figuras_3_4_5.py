'''
Created on 11 dic 2022

@author: raulh
'''

def distanciaEuclidea(x1,y1,x2,y2):
    distancia=((x2-x1)**2+(y2-y1)**2)**0.5
    return distancia

def trianguloEnElPlano(x1,y1,x2,y2,x3,y3,a=False):
    distancia12=distanciaEuclidea(x1, y1, x2, y2)
    distancia13=distanciaEuclidea(x1, y1, x3, y3)
    distancia23=distanciaEuclidea(x3, y3, x2, y2)
    if not(a):    
        return distancia12+distancia13+distancia23
    else:
        return distancia12, distancia13, distancia23
    
def areaDelTriangulo(x1,y1,x2,y2,x3,y3):
    semiperimetro=(trianguloEnElPlano(x1, y1, x2, y2, x3, y3))/2
    ladoA, ladoB, ladoC = trianguloEnElPlano(x1, y1, x2, y2, x3, y3, True)
    area=(semiperimetro*(semiperimetro-ladoA)*(semiperimetro-ladoB)*(semiperimetro-ladoC))**0.5
    return area
    
print(distanciaEuclidea(-3, 1, 1, -2))
print(trianguloEnElPlano(1, 1, 3, 5, 4, 2))
print(areaDelTriangulo(-3, 1, 1, -2, 4, 2))