import '../StyleSheets/myStyle.css'
const decimalToPercent = (decimal) => {
    return (decimal.toFixed(2) + '%')
}
const calcScore = (total, goal) => {
    return decimalToPercent(total/goal)
}
export const CalculateScore = ({Name, School, Total, Goal}) => {
    return(
        <div className="formatStyle">
        <h1 style={{ color: 'brown' }}>Student Details:</h1>
        <div className="Name">
            <b>Name: </b>
            <span>{Name}</span>
        </div>
        <div className="School">
            <b>School: </b>
            <span>{School}</span>
        </div>
        <div className="Total">
            <b>Total: </b>
            <span>{Total} Marks</span>
        </div>
        <div className="Score">
            <b>Score: </b>
            <span>{calcScore(Total, Goal)}</span>
        </div>
    </div>
    )
}