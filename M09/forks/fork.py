import os
def parent():
	
	for i in range(3):
		id=os.fork()
		if (id != 0):
			print "Yo soy tu padre! ",id
			print "Id Proceso ", os.getpid()
			print "Id padre ", os.getppid()
		else:

			print "Soy Luke Skywalker ",id
			break	
		print "Hola"
parent()
