import { useEffect, useState } from "react";
import './watch.css'
const baseUrl = 'http://localhost:8080';

export default function Fetch() {
    const [data, setData] = useState(' ');

    useEffect(() => {
      const fetchTime = async () => {
        fetch('http://localhost:8080/time')
        .then(response => response.text()) 
        .then(data => setData(data))
        .catch(error => console.error('Error:', error));
      }

      fetchTime();
      const intervalId = setInterval(fetchTime, 1000);
      return () => clearInterval(intervalId);

    }, []); 
  
    return (
      <div className="watch">
        <h1>{data}</h1>
      </div>
    );
}
