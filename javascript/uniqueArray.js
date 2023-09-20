//Enter a string of elements into array
str = prompt("Enter the array elements seperated by comma: ");
arr = str.split(",");
var i,j;
var newArr=[];
//returns index of an element in new array, to check if duplicate exists
function inArray(val, arr){
    return arr.indexOf(val);
}
for(i=0; i<arr.length; i++){
    if((inArray(arr[i],newArr))>-1){
        continue;
    }
    else{
        newArr.push(arr[i]);
    }
}
console.log(newArr);