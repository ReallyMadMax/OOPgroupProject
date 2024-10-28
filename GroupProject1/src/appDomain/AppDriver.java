package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;

public class AppDriver {

	static File shapesFile = new File(
			"C:\\CPRG304\\assignment1StartingCode\\assignment1StartingCode\\res\\shapes1.txt");
	static File shapesFile2 = new File(
			"C:\\CPRG304\\assignment1StartingCode\\assignment1StartingCode\\res\\shapes2.txt");
	static File shapesFile3 = new File(
			"C:\\CPRG304\\assignment1StartingCode\\assignment1StartingCode\\res\\shapes3.txt");

	// Method to print by the volume
	public static void printByVolume(Shape[] shapes) {
		System.out.println("First element is: " + shapes[0].getName() + " has a Volume of: " + shapes[0].calcVolume());

		for (int i = 1000; i < shapes.length; i += 1000) {
			System.out.println(
					i + "-th element is: " + shapes[i].getName() + " has a Volume of: " + shapes[i].calcVolume());
		}

		System.out.println("Last element is: " + shapes[shapes.length - 1].getName() + " has a Volume of: "
				+ shapes[shapes.length - 1].calcVolume());
	}

	// Method to print by the height
	public static void printByHeight(Shape[] shapes) {
		System.out.println("First element is: " + shapes[0].getName() + " has a Height of: " + shapes[0].height);

		for (int i = 1000; i < shapes.length; i += 1000) {
			System.out.println(i + "-th element is: " + shapes[i].getName() + " has a Height of: " + shapes[i].height);
		}

		System.out.println("Last element is: " + shapes[shapes.length - 1].getName() + " has a Height of: "
				+ shapes[shapes.length - 1].height);
	}

	// Method to print by base area
	public static void printByBaseArea(Shape[] shapes) {
		System.out.println(
				"First element is: " + shapes[0].getName() + " has a Base Area of: " + shapes[0].calcBaseArea());

		for (int i = 1000; i < shapes.length; i += 1000) {
			System.out.println(
					i + "-th element is: " + shapes[i].getName() + " has a Base Area of: " + shapes[i].calcBaseArea());
		}

		System.out.println("Last element is: " + shapes[shapes.length - 1].getName() + " has a Base Area of: "
				+ shapes[shapes.length - 1].calcBaseArea());
	}

	public static void main(String[] args) throws FileNotFoundException {

		// Variables are being assigned null as placeholders for the arguments
		String fileToRead = null;
		String sortCriteria = null;
		String sortType = null;

		// looping through all of the command line arguments
		for (String argument : args) {
			// If argument starts with "-f" (fileName)
			if (argument.toLowerCase().startsWith("-f")) {
				// Get the file name
				fileToRead = argument.substring(2);
			}
			// If argument starts with "-t" (Sorting Criteria)
			if (argument.toLowerCase().startsWith("-t")) {
				// Get the sorting criteria
				sortCriteria = argument.substring(2);
			}
			// If argument starts with "-s" (Sorting Type)
			if (argument.toLowerCase().startsWith("-s")) {
				// Get the sorting type
				sortType = argument.substring(2);
			}

			// This for loop allows for the user to input arguments in any order
		}

		// Check if arguments are null or empty
		if (sortCriteria == null || sortCriteria.isEmpty() || sortType == null || sortType.isEmpty()) {
			System.out.println("One of the following arguments is empty."); // Add usefull error message
			System.out.println("Proper Format = -f <fileName> -t <sortingCriteria> -s ");
			return;
		}

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file
		File file = new File(fileToRead);
		Scanner scanner = new Scanner(file);

		String listSizeString = scanner.next();
		// Have to convert listsize to a string
		int listSize = Integer.parseInt(listSizeString);
		Shape[] shapes = new Shape[listSize];

		// Since arrays are a fixed size upon creation and cannot be changed
		// We have to specify at what index we are inserting the object
		int index = 0;
		while (scanner.hasNextLine()) {

			String line = scanner.nextLine();
			String[] parts = line.split(" ");
			String shapeType = parts[0];

			switch (shapeType) {
				case "Cone":
					// New Instance of Cone
					Cone cone = new Cone(
							// Indicating type of shape
							shapeType,
							Double.parseDouble(parts[1]),
							Double.parseDouble(parts[2]));
					// Assigns to array @ index
					shapes[index] = cone;
					// Moves to next in the index
					index++;
					break;

				case "Cylinder":
					// New Instance of Cylinder
					Cylinder cylinder = new Cylinder(
							shapeType,
							Double.parseDouble(parts[1]),
							Double.parseDouble(parts[2]));
					// Assigns to array @ index
					shapes[index] = cylinder;
					// Moves to next in the index
					index++;
					break;
				case "OctagonalPrism":
					// New instance of Octagonal Prism
					OctagonalPrism octagonalPrism = new OctagonalPrism(
							shapeType,
							Double.parseDouble(parts[1]),
							Double.parseDouble(parts[2]));
					// Assigns to array @ index
					shapes[index] = octagonalPrism;
					// Moves to next in the index
					index++;
					break;
				case "PentagonalPrism":
					// New instance of Pentagonal Prism
					PentagonalPrism pentagonalPrism = new PentagonalPrism(
							shapeType,
							Double.parseDouble(parts[1]),
							Double.parseDouble(parts[2]));
					// Assigns to array @ index
					shapes[index] = pentagonalPrism;
					// Moves to the next in the index
					index++;
					break;
				case "Pyramid":
					// New Instance of Pyramid
					Pyramid pyramid = new Pyramid(
							shapeType,
							Double.parseDouble(parts[1]),
							Double.parseDouble(parts[2]));
					// Assigns to array @ index
					shapes[index] = pyramid;
					// Moves to the next in the index
					index++;
					break;
				case "SquarePrism":
					// New instance of Square Prism
					SquarePrism squarePrism = new SquarePrism(
							shapeType,
							Double.parseDouble(parts[1]),
							Double.parseDouble(parts[2]));
					// Assign to array @ index
					shapes[index] = squarePrism;
					// Moves to the next index
					index++;
					break;
				case "TriangularPrism":
					// New Instance of Triangular Prism
					TriangularPrism triangularPrism = new TriangularPrism(
							shapeType,
							Double.parseDouble(parts[1]),
							Double.parseDouble(parts[2]));
					// Assign to array @ index
					shapes[index] = triangularPrism;
					// Moves to the next index
					index++;
					break;
			}
		}

		scanner.close();

		// Nested Switch case to allow arguments to sort by the criteria
		// and to sort by the type.
		// Using toLowerCase because we are only comparing prefixes and
		// not entire string statements
		switch (sortCriteria.toLowerCase()) {
			case "v": // Sorting by volume
				switch (sortType.toLowerCase()) {
					case "b": // Bubble sorting
						long startTimeBubble = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeBubble = System.currentTimeMillis();
						System.out.println("Bubble Sort took: " + (endTimeBubble - startTimeBubble) + " ms");
						break;
					case "s": // Selection sorting
						long startTimeSorting = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeSorting = System.currentTimeMillis();
						System.out.println("Selection Sort took: " + (endTimeSorting - startTimeSorting) + " ms");
						break;
					case "i": // Insertion sorting
						long startTimeInsertion = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeInsertion = System.currentTimeMillis();
						System.out.println("Insertion Sort took: " + (endTimeInsertion - startTimeInsertion) + " ms");
						break;
					case "m": // Merge sorting
						long startTimeMerge = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeMerge = System.currentTimeMillis();
						System.out.println("Merge Sort took: " + (endTimeMerge - startTimeMerge) + " ms");
						break;
					case "q": // Quick sorting
						long startTimeQuick = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeQuick = System.currentTimeMillis();
						System.out.println("Quick Sort took: " + (endTimeQuick - startTimeQuick) + " ms");
						break;
					case "h": // Heapsort
						long startTimeHeap = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeHeap = System.currentTimeMillis();
						System.out.println("Heap Sort took: " + (endTimeHeap - startTimeHeap) + " ms");
						break;
					default:
						System.out.println("Invalid sort type for Volume Sorting.");
						System.out.println(
								"Please ensure your command line argument matches one of the expected sorting algorithms.");
						System.out.println(
								"<b> Bubble Sort / <s> Selection Sort / <i> Insertion Sort / <m> Merge Sort / <q> Quick Sort / <h> Heapsort");
						break;
				}
				break;

			case "h": // Sorting by height
				switch (sortType.toLowerCase()) {
					case "b":
						long startTimeBubble = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeBubble = System.currentTimeMillis();
						System.out.println("Bubble Sort took: " + (endTimeBubble - startTimeBubble) + " ms");
						break;
					case "s":
						long startTimeSorting = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeSorting = System.currentTimeMillis();
						System.out.println("Sorting Sort took: " + (endTimeSorting - startTimeSorting) + " ms");
						break;
					case "i":
						long startTimeInsertion = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeInsertion = System.currentTimeMillis();
						System.out.println("Insertion Sort took: " + (endTimeInsertion - startTimeInsertion) + " ms");
						break;
					case "m":
						long startTimeMerge = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeMerge = System.currentTimeMillis();
						System.out.println("Merge Sort took: " + (endTimeMerge - startTimeMerge) + " ms");
						break;
					case "q":
						long startTimeQuick = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeQuick = System.currentTimeMillis();
						System.out.println("Quick Sort took: " + (endTimeQuick - startTimeQuick) + " ms");
						break;
					case "h":
						long startTimeHeap = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeHeap = System.currentTimeMillis();
						System.out.println("Heap Sort took: " + (endTimeHeap - startTimeHeap) + " ms");
						break;
					default:
						System.out.println("Invalid sort type for height sorting.");
						System.out.println(
								"Please ensure your command line argument matches one of the expected sorting algorithms.");
						System.out.println(
								"Options: <b> Bubble Sort / <s> Selection Sort / <i> Insertion Sort / <m> Merge Sort / <q> Quick Sort / <h> Heapsort");
						break;
				}
				break;

			case "a": // Sorting by base area
				switch (sortType.toLowerCase()) {
					case "b":
						long startTimeBubble = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeBubble = System.currentTimeMillis();
						System.out.println("Bubble Sort took: " + (endTimeBubble - startTimeBubble) + " ms");
						break;
					case "s":
						long startTimeSorting = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeSorting = System.currentTimeMillis();
						System.out.println("Sorting Sort took: " + (endTimeSorting - startTimeSorting) + " ms");
						break;
					case "i":
						long startTimeInsertion = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeInsertion = System.currentTimeMillis();
						System.out.println("Insertion Sort took: " + (endTimeInsertion - startTimeInsertion) + " ms");
						break;
					case "m":
						long startTimeMerge = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeMerge = System.currentTimeMillis();
						System.out.println("Merge Sort took: " + (endTimeMerge - startTimeMerge) + " ms");
						break;
					case "q":
						long startTimeQuick = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeQuick = System.currentTimeMillis();
						System.out.println("Quick Sort took: " + (endTimeQuick - startTimeQuick) + " ms");
						break;
					case "h":
						long startTimeHeap = System.currentTimeMillis();
						// Insert sort logic here
						long endTimeHeap = System.currentTimeMillis();
						System.out.println("Heap Sort took: " + (endTimeHeap - startTimeHeap) + " ms");
						break;
					default:
						System.out.println("Invalid sort type for base area sorting.");
						System.out.println(
								"Please ensure your command line argument matches one of the expected sorting algorithms.");
						System.out.println(
								"<b> Bubble Sort / <s> Selection Sort / <i> Insertion Sort / <m> Merge Sort / <q> Quick Sort / <h> Heapsort");
						break;
				}
				break;

			default:
				System.out.println("Invalid sort criteria.");
				System.out.println("Make sure that your command line argument matches the expected Sort Criteria");
				System.out.println("Options are as follows: ");
				System.out.println("<v> Sort by volume / <h> Sort by height / <a> Sory by base area");
				break;
		}
	}
}
