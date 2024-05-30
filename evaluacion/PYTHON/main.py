import os, csv

os.system('cls')

def ejemplo1():
    nra = 'C:\\EXAMEN\\PYTHON\\transaccion.csv'
    try:
         with open(nra, 'r') as f:
              filas = csv.reader(f,delimiter=';')
              filas_lst = list(filas)
              
              print(type(filas_lst))
              print(list(filas_lst))
    except:
        print('ERROR: LECTURA')

def ejemplo2():
    nra = 'C:\\EXAMEN\\PYTHON\\transaccion.csv'
    try:
         with open(nra, 'r') as f:
              filas = csv.reader(f,delimiter=';')
              filas_lst = list(filas)
              for fila in filas_lst:
                  print(fila)
    except:
        print('ERROR: LECTURA')
     
def ejemplo3():
    nra = 'C:\\EXAMEN\\PYTHON\\transaccion.csv'
    try:
         with open(nra, 'r') as f:
              filas = csv.reader(f,delimiter=';')
              filas_lst = list(filas)
              cabecera()
              for fila in filas_lst:
                  idTransaccion =  fila[0] 
                  ciudad = fila[1] 
                  zona = fila[2]
                  ventas = fila[3]
                  formaPago = fila[4]
                  categoria = fila[5]
                  cuerpo("IDTRANSACCION","CIUDAD","ZONA","VENTAS","FORMA PAGO","CATEGORIA")
    except:
        print('ERROR: LECTURA')

def cabecera():
    print('%-12s %-12s %-12s %16s %-12s %16s' % ('IDTRANSACCION','CIUDAD','ZONA','VENTAS','FORMA-PAGO','CATEGORIA'))
    print('%-12s %-12s %-12s %16s %-12s %16s' % ('-------------','------','----','------','----------','---------'))

def cuerpo(idTransaccion,ciudad,zona,ventas,formaPago,categoria):
    print('%-12s %-12s %-12s %16s %-12s %16s' % (idTransaccion,ciudad,zona,ventas,formaPago,categoria))

ejemplo2()