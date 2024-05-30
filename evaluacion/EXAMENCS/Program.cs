using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using static System.Net.WebRequestMethods;

namespace EXAMENCS
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.ForegroundColor = ConsoleColor.White;
            Console.BackgroundColor = ConsoleColor.Magenta;
            do
            {
                Cls();
                Console.WriteLine("MENU");
                Console.WriteLine("----");
                Console.WriteLine("[1] MOSTRAR TODAS LAS ZONAS DIFERENTES");
                Console.WriteLine("[2] MOSTRAR TODAS LAS CIUDADES DIFERENTES");

                Console.WriteLine("[0] SALIR");

                Console.Write("\nINGRESE OPCION? ");
                string opcion = Console.ReadLine();

                switch (opcion)
                {
                    case "1":
                        Cls();
                        Opcion1();
                        break;
                    case "2":
                        Cls();
                        Opcion2();
                        break;

                    case "0":
                        Cls();
                        Console.WriteLine("GRACIAS POR SU VISITA");
                        Pause();
                        Cls();
                        Environment.Exit(0);
                        break;
                }
            } while (true);
        }

        static void Cls()
        {
            Console.Clear();
        }

        static void Pause()
        {
            Console.Write("Presione una tecla para continuar...");
            Console.Read();
        }



        static void Opcion1()
        {
            Console.WriteLine("[1] MOSTRAR TODAS LAS ZONAS DIFERENTES");
            Console.WriteLine("--------------------------------------");
            SortedSet<string> esteticistas = new SortedSet<string>();

            string rutaRelativa = "DATA/Transaccion.csv";
            string rutaAbsoluta = Path.GetFullPath(rutaRelativa);
            //Console.WriteLine("RUTA ABSOLUTA: " + rutaAbsoluta);
            string fila = "";
            using (StreamReader sr = new StreamReader(rutaAbsoluta))//ABRIR
            {
                while ((fila = sr.ReadLine()) != null)
                {//LEER
                    string[] partes = fila.Split(';');
                    esteticistas.Add(partes[2]);
                }
                sr.Close();//CERRAR
                foreach (String s in esteticistas)
                {
                    if (s != "ZONA")
                    {
                        Console.WriteLine(s);
                    }
                }
            }

            Pause();
        }

        static void Opcion2()
        {
            Console.WriteLine("[3] MOSTRAR TODAS LAS CIUDADES DIFERENTES");
            Console.WriteLine("----------------------------------");
            SortedSet<string> esteticistas = new SortedSet<string>();

            string rutaRelativa = "DATA/Transaccion.csv";
            string rutaAbsoluta = Path.GetFullPath(rutaRelativa);
            //Console.WriteLine("RUTA ABSOLUTA: " + rutaAbsoluta);
            string fila = "";
            using (StreamReader sr = new StreamReader(rutaAbsoluta))//ABRIR
            {
                while ((fila = sr.ReadLine()) != null)
                {//LEER
                    string[] partes = fila.Split(';');
                    esteticistas.Add(partes[1]);
                }
                sr.Close();//CERRAR
                foreach (String s in esteticistas)
                {
                    if (s != "CIUDAD")
                    {
                        Console.WriteLine(s);
                    }
                }
            }

            Pause();
        }



    }
}

