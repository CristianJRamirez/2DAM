import os
def parent():
	
	for i in range(4):
		id=os.fork()
		if (id != 0):
			print "Yo soy tu padre! ",id
			print "Id Proceso ", os.getpid()
			print "Id padre ", os.getppid()
			break	
	else:

			print "Soy Luke Skywalker ",id
		#	break	
	
parent()
