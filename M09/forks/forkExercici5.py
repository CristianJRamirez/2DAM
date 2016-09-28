
import os
def parent():
	
	for i in range(2):
		id=os.fork()
		if (id == 0):
			print "Soy Luke Skywalker ",id
			break				
		else:

			print "Yo soy tu padre! ",id
               		print "Id Proceso ", os.getpid()

	                print "Id padre ", os.getppid()




        for i in range(2):
                id=os.fork()
                if (id == 0):
                        print "Soy Luke Skywalker ",id
                    #    break
                else:

                        print "Yo soy tu padre! ",id
                        print "Id Proceso ", os.getpid()

                        print "Id padre ", os.getppid()
			break

parent()
