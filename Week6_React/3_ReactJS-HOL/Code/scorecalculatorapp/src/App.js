import './App.css';
import { CalculateScore } from './Components/CalculateScore';
function App() {
  return (
    <div>
      <CalculateScore Name={"Steeve"}
      School={"DNV Public School"}
      Total={284}
      Goal={3}/>
    </div>
  );
}

export default App;
