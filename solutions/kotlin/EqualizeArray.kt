
// probably there's a way to do this using chuncked method, but I could think in a way until now
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/chunked.html
fun equalizeArray(arr: Array<Int>): Int {
    arr.sort()
    
    var lastEl = 0
    var biggerCount = 0
    var currentCount = 0
    
    for(i in arr.indices){
        if (i == 0){
            lastEl = arr[i]
            currentCount = 1
            continue
        }
        if(arr[i] == lastEl){
            currentCount++
            if(i == arr.size - 1 && biggerCount < currentCount){
                biggerCount = currentCount
            }
        }else{
            if(biggerCount < currentCount){
                biggerCount = currentCount
            }
            lastEl = arr[i]
            currentCount = 1
        }
    }
    return arr.size - biggerCount
}