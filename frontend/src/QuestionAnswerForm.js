import React, { useState } from "react"; 
import axios from 'axios';



function postData(e,data){
    e.preventDefault()
    // Be sure that you set Content-Type: application/xml in the headers of your request.


    const url = "http://localhost:8080/api/flashcards/";
    fetch(url, {method: "POST", 
    body: JSON.stringify(data), 
    headers: {
        'Content-Type': 'application/json',
        // 'Content-Type': 'application/x-www-form-urlencoded',
    }}).then( res =>{

        console.log(res);
    } );

}
// try to update stage to 1 or 0
function update(e,no){
  e.preventDefault();
  const url = "http://localhost:8080/api/flashcards/" + no;

  axios.post(url, {})
  fetch(url, {method: "PUT", 
  body: JSON.stringify(no), 
  headers: {
      'Content-Type': 'application/json',
      // 'Content-Type': 'application/x-www-form-urlencoded',
  }}).then( res =>{

    console.log("hi");
      console.log(res);
  } );

}
//$ curl -X PUT localhost:8080/employees/3 -H 'Content-type:application/json' -d '{"name": "Samwise Gamgee", "role": "ring bearer"}'

function Form() { 
 const h = 1;
  const [question, setQuestion] = useState("");
  const [answer, setAnswer] = useState(""); 
  const [stage, setStage] = useState(1);

return (
  <div>
    <form onSubmit={e => postData(e,{question, answer})}>
      <input
        value={question}
        onChange={e => setQuestion(e.target.value)}
        placeholder="Question"
        type="text"
        name="Question"
        required
      />
      <input
        value={answer}
        onChange={e => setAnswer(e.target.value)}
        placeholder="Answer (optional)"
        type="text"
        name="Answer" 
      /> 
<button type="submit">Submit</button>
    </form>
    <form onSubmit={e => update( e, stage )}>
      <input
        value={stage}
        onChange={e => setStage(e.target.value)}
        placeholder="Enter Stage or whatever"
        type="number"
        name="number"
         
      /> 
<button type="submit">Submit</button>
    </form>
  </div>
  );
}
export default Form;