
JAVAC = javac
JAVA = java

CASE1_DIR = soal-case-1
CASE2_DIR = soal-case-2

# Default target
all: build-case1 build-case2
	
# Run targets
run-case-1:
	@echo "Building soal-case-1 (Infix to Postfix/Prefix)..."
	cd $(CASE1_DIR) && $(JAVAC) *.java
	@echo "soal-case-1 build complete!"

	@echo "Running soal-case-1 (Infix to Postfix/Prefix)..."
	cd $(CASE1_DIR) && $(JAVA) -cp . Main

run-case-2:
	@echo "Building soal-case-2 (Simple Queue)..."
	cd $(CASE2_DIR) && $(JAVAC) *.java
	@echo "soal-case-2 build complete!"

	@echo "Running soal-case-2 (Simple Queue)..."
	cd $(CASE2_DIR) && $(JAVA) -cp . SimpleQueue

clean-all:
	cd $(CASE1_DIR) && rm -f *.class
	cd $(CASE2_DIR) && rm -f *.class

# Help target
help:
	@echo "Available targets:"
	@echo "  run-case-1        - Run soal-case-1"
	@echo "  run-case-2        - Run soal-case-2"
	@echo "  clean-all        - Clean all compiled files"
	@echo "  help             - Show this help message"

# Phony targets
.PHONY: all run-case-1 run-case-2 clean-all help