CC = gcc
CFLAGS = -W
TARGET = diary_exe
OBJECTS = memo.o main.o calendar.o

all : $(TARGET)

$(TARGET) : $(OBJECTS)
	$(CC) $(CFLAGS) -o $@ $^

clean :
	rm *.o diary_exe