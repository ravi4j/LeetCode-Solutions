/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    var table = [
        [
            1000, "M"
        ],
        [
            900, "CM"
        ],
        [
            500, "D"
        ],
        [
            400, "CD"
        ],
        [
            100, "C"
        ],
        [
            90, "XC"
        ],
        [
            50, "L"
        ],
        [
            40, "XL"
        ],
        [
            10, "X"
        ],
        [
            9, "IX"
        ],
        [
            5, "V"
        ],
        [
            4, "IV"
        ],
        [
            1, "I"
        ]
    ];
    var roman = "";
    for (var i = 0; i < table.length; i++) {
        while (num >= table[i][0]) {
            roman += table[i][1];
            num -= table[i][0];
        }
    }
    return roman;
};


var INPUT = 9;
var result = intToRoman(INPUT);
console.log(result);