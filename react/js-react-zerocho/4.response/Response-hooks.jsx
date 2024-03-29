import React, { useRef, useState } from 'react';

const Response = () => {
    const [state, setState] = useState('waiting');
    const [message, setMessage] = useState('클릭해서 시작하세요.');
    const [result, setResult] = useState([]);

    const timeout = useRef(null);
    const startTime = useRef();
    const endTime = useRef();

    const onClickScreen = () => {
        if (state === 'waiting') {
            setState('ready');
            setMessage('초록색이 되면 클릭하세요.');
            timeout.current = setTimeout(() => {
                setState('now');
                setMessage('지금 클릭하세요!!!');
                startTime.current = new Date();
            }, Math.floor(Math.random() * 1000 + 2000));
        } else if (state === 'ready') {
            clearTimeout(timeout.current);
            setState('waiting');
            setMessage('클릭해서 시작하세요.');
            alert('너무 성급하시군요!');
        } else if (state === 'now') {
            endTime.current = new Date();
            setState('waiting');
            setMessage('클릭해서 시작하세요.');
            setResult((prevResult) => {
                return [...prevResult, endTime.current - startTime.current];
            });
        }
    }

    const onReset = () => {
        setResult([]);
    }

    return (
        <>
            <div id="screen" className={state} onClick={onClickScreen}>
                {message}
            </div>
            {/* {result.length === 0 ? null : <>
                <div>평균 시간: {result.reduce((a, c) => a + c) / result.length}ms</div>
                <button onClick={onReset}>리셋</button>
            </>} */}
            {(() => {
                if (result.length === 0) {
                    return null;
                } else {
                    return <>
                        <div>평균 시간: {result.reduce((a, c) => a + c) / result.length}ms</div>
                        <button onClick={onReset}>리셋</button>
                    </>
                }
            })()}
        </>
    )
}

export default Response;