function print_table_content(){
    var data =  [
        {
        "id": 1,
        "name": "Bruce Wayne",
        "subject1": 80,
        "subject2": 45,
        "subject3":90
        
        },
        {
        "id": 2,
        "name": "Diana",
        "subject1": 56,
        "subject2": 74,
        "subject3":78
        },
        {
        "id": 3,
        "name": "Clark Kent",
        "subject1": 67,
        "subject2": 78,
        "subject3":90
        },
        {
        "id": 4,
        "name": "Barry Allen",
        "subject1": 89,
        "subject2": 35,
        "subject3":64
        },
        {
        "id": 5,
        "name": "Arthur Curry",
        "subject1": 76,
        "subject2": 65,
        "subject3":100
        },
        {
        "id": 6,
        "name": "Victor Stone",
        "subject1": 99,
        "subject2": 87,
        "subject3":64
        }
    ];
    var i = 0;
    var j = 0;
   /* for(i = 0 ; i<data.length ; i++){
        for (const key in data[i]) {
            //document.getElementById(i.toString + j.toString).innerHTML = data[i][key];
            console.log()
            j = j+1;
        }

    }*/

    for(let d of data){

        Object.values(d).forEach(value=>{
            console.log(i.toString() + j.toString() + " " + value);
            document.getElementById(i.toString() + j.toString()).innerHTML = value;
            j = j+1;
            if(j>=Object.keys(d).length){
                j = 0;
            }
         });
      /*  for (const key in d) {
            document.getElementById(i.toString + j.toString).innerHTML = d[key];
            //console.log(d[key])
            j = j+1;
        }*/
        i = i+1;
        if(i>=data.length){
            i = 0;
        }
      }
      console.log(i)
      console.log(j)
      i = 0;
      j = 5;
      const max_marks = data.map(d => Math.max(d.subject1,d.subject2,d.subject3));
      for(i =0;i<data.length;i++){
        document.getElementById(i.toString() + j.toString()).innerHTML = max_marks[i];
      }
      console.log(max_marks);
   
}