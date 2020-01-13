#!/bin/bash
file=/home/hari/init.sh
if [ ! -f "$file" ]
then
	echo "$0: file '${file}' not found: Exiting"
	exit
else
	echo "File  Found: proceeding"
	fi
echo "vikas"
cd /home/hari/scm_plus1/datagrid/CassandraRecon/bin
#based on the user input
case $1 in
EAST) touch driver_EAST.txt
        case $2 in
        WEEKLY)
                echo $3,$1,$2,,>>driver_EAST.txt;;
        
        DAILY)
               echo $3,$1,$2,$4>>driver_EAST.txt;;
        MONTHLY)
               echo $3,$1,$2,$4>>driver_EAST.txt;;
        
             *) echo "Incorrect FREQUENCY name"
        ;;
        esac
;;
WEST) touch driver_WEST.txt
        case $2 in
        WEEKLY)
                echo $3,$1,$2,,>>driver_WEST.txt;;
        
        DAILY)
               echo $3,$1,$2,$4>>driver_WEST.txt;;
        MONTHLY)
               echo $3,$1,$2,$4>>driver_WEST.txt;;
        
             *) echo "Incorrect FREQUENCY name"
        ;;
        esac
;;
NORTHEAST) touch driver_NORTHEAST.txt
        case $2 in
        WEEKLY)
                echo $3,$1,$2,,>>driver_NORTHEAST.txt;;
        
        DAILY)
               echo $3,$1,$2,$4>>driver_NORTHEAST.txt;;
        MONTHLY)
               echo $3,$1,$2,$4>>driver_NORTHEAST.txt;;
        
             *) echo "Incorrect FREQUENCY name"
        ;;
        esac
;;
B2B) touch driver_B2B.txt
        case $2 in
        WEEKLY)
                echo $3,$1,$2,,>>driver_B2B.txt;;
        
        DAILY)
               echo $3,$1,$2,$4>>driver_B2B.txt;;
        MONTHLY)
               echo $3,$1,$2,$4>>driver_B2B.txt;;
        
             *) echo "Incorrect FREQUENCY name"
        ;;
        esac
;;



*) echo "Incorrrect Instance Name"
;;
esac
case $1 in
    EAST)
	nohup ./recon_EAST.sh $5 $1 $2 &;;
    WEST)
	nohup ./recon_WEST.sh $5 $1 $2 &;;
	NORTHEAST)
	nohup ./recon_NORTH.sh  $5 $1 $2 &;;
	B2B)
	nohup ./recon_B2B.sh $5 $1 $2 $;;
	*) echo "Sorry, I can not get a  rental for you";;
   esac  
