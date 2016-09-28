
import os
def parent():

	print "Estem al primer fork"
        newpid=os.fork()
        pids= (os.getppid(),os.getpid())
	print ("pare %d ,fill %d"%pids)

        print "----------"


	print "Estem al 2 fork"
	newpid2=os.fork()
	pids2 = (os.getppid(),os.getpid())
	print ("pare %d ,fill %d"%pids2)

	print "----------"


        print "Estem al 3 fork"
        newpid3=os.fork()
        pids3 = (os.getppid(),os.getpid())
        print ("pare %d ,fill %d"%pids3)


parent()
