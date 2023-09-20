//program to detect if two strings are anagrams
//take user input
var str1 = prompt("Enter the first string: ");
var str2 = prompt("Enter the second string: ");

function reorder(str){
    return str.split("").sort().join("");
}
if(reorder(str1)==reorder(str2)){
    console.log("True");
}
else{
    console.log("False");
}