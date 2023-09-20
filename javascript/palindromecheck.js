//program to check if an input string is palindrome
//prompt user input
var str = prompt("Enter a string: ");

//splits the string into array, reverses array, joins the array elements
//into a string and returns it
function reverseString(str){
    return str.split("").reverse().join("");
}
//condition
if(str == reverseString(str)){
    console.log("True")
}
else{
    console.log("False")
}
