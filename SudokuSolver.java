import java.util.*;
class SudokuSolver
{public static void main(String args[])
    {Scanner sc=new Scanner (System.in);
     String grid[][]=new String[9][9];
     System.out.println ("Enter grid. Leave spaces for blanks");
     int count=0;
     for (byte i=0; i<9; i++)
     {String a=sc.nextLine();
         for (byte j=0; j<9; j++)
        {if(Character.isDigit(a.charAt(j)))
            grid[i][j]=Character.toString(a.charAt(j));
         else
            grid[i][j]="123456789";
            }
        }
     while (true)
     {int r=count;
         for (byte i=0; i<9; i++)
         {for (byte j=0; j<9; j++)
             {if (grid[i][j].length()==1)
                 {count++;
                  String x=grid[i][j].substring(0,1);
                  remove(grid, i, j);
                  grid[i][j]="C"+x;
                    }
                }
            }
      if (r==count)
      {for (byte i=1; i<=9; i++)
       {char x=(char)(48+i);
        byte pos1i=0,pos1j=0,pos2i=0,pos2j=0;
        byte counter1=0,counter2=0;
           for (byte j=0; j<9; j++)
           {for (byte k=0; k<9; k++)
               {if (grid[j][k].indexOf(x)!=-1&&grid[j][k].charAt(0)!='C')
                   {counter1++;
                     pos1i=j;
                     pos1j=k;
                    }
                else if (grid[k][j].indexOf(x)!=-1&&grid[k][j].charAt(0)!='C')
                   {counter2++;
                       pos2i=k;
                       pos2j=j;
                    }
                }
            }
            if (counter1==1)
                { grid[pos1i][pos1j]=Character.toString(x);
                    remove(grid, pos1i, pos1j);
                  count++;
                  grid[pos1i][pos1j]="C"+Character.toString(x);
                }
                else if (counter2==1)
                {grid[pos2i][pos2j]=Character.toString(x);
                    remove(grid, pos2i, pos2j);
                 count++;
                  grid[pos2i][pos2j]="C"+Character.toString(x);}
        for (byte j=0; j<3; j++)
        {for (byte k=0; k<3; k++)
            {byte counter3=0;
             byte pos3i=0,pos3j=0;
                for (byte l=0; l<3; l++)
                {for (byte m=0; m<3; m++)
                    {if (grid[3*j+l][3*k+m].indexOf(x)!=-1&&grid[3*j+l][3*k+m].charAt(0)!='C')
                        {counter3++;
                         pos3i=(byte)(3*j+l);
                         pos3j=(byte)(3*k+m);
                        }
                    }
                }
             if (counter3==1)
             {grid[pos3i][pos3j]=Character.toString(x);
                 remove (grid, pos3i, pos3j);
              count++;
              grid[pos3i][pos3j]="C"+Character.toString(x);
                }
            }
        }
        }
        if (r==count||count>81)
        {System.out.println ("Unable to Completely Solve Sudoku. Erraneous Matrix-");
         for (byte i=0; i<9; i++)
      {for (byte j=0; j<9; j++)
          {System.out.print(grid[i][j]+"\t");
            }
       System.out.println();
        }
       break;
       }
        }
      if (count==81)
      { System.out.println ("Success");
          for (byte i=0; i<9; i++)
        {for (byte j=0; j<9; j++)
          {System.out.print(grid[i][j].charAt(1)+" ");
            }
        System.out.println();
        }
        break;
        }
      /* for (byte i=0; i<9; i++)
      {for (byte j=0; j<9; j++)
          {System.out.print(grid[i][j]+" ");
            }
       System.out.println();
        }
        System.out.println("Count="+count+"r="+r+"\n");*/
    }
    }
 static void remove(String grid[][], byte i, byte j)
 {char a=grid[i][j].charAt(0);
     for (byte I=0; I<9; I++)
     {if (grid[i][I].indexOf(a)!=-1)
         {grid[i][I]=grid[i][I].substring(0, grid[i][I].indexOf(a))+grid[i][I].substring(grid[i][I].indexOf(a)+1);
            }
        }
    for (byte I=0; I<9; I++)
     {if (grid[I][j].indexOf(a)!=-1)
         {grid[I][j]=grid[I][j].substring(0, grid[I][j].indexOf(a))+grid[I][j].substring(grid[I][j].indexOf(a)+1);
            }
        }
    byte II=(byte)(3*(i/3));
    byte JJ=(byte)(3*(j/3));
    for (byte I=II; I<II+3; I++)
    {for (byte J=JJ; J<JJ+3; J++)
        {if (grid[I][J].indexOf(a)!=-1)
            {grid[I][J]=grid[I][J].substring(0, grid[I][J].indexOf(a))+grid[I][J].substring(grid[I][J].indexOf(a)+1);
            }
        }
    }
    }
}
//total length =126 lines (91 actual lines)+(35 lines only containing '}' XD)
