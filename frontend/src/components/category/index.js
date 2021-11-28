import {useEffect, useState} from "react";
import CategoryPanel from "./CategoryPanel";
import {Button, Icon, IconButton, Loader, Message} from "rsuite";
import {getAllCategories} from "../../util/apiCall/CategoryApiCall"
import CreateCategoryPanel from "./CreateCategoryPanel";

const CategoryList = () => {
    const [ categories, setCategories]  = useState();
    const [ error, setError ] = useState(false);
    const [ pending, setPending ] = useState(false);
    const [ createMode, setCreateMode ] = useState(false)

    useEffect( () => {
        getAllCategories()
        .then(response => {
            if (response.status === 200) {
                setCategories(response.data.content);
            }
        })
    }, [])

    const toggleCreateMode = () => {
        setCreateMode(!createMode)
    }

    return (
        <div className='container p-5 mt-5'>
            <IconButton color={!createMode ? 'cyan' : 'red'} className='mb-3' onClick={toggleCreateMode} appearance='primary'>
                <Icon icon={!createMode ? 'plus-circle' : 'close-circle'} />
                {!createMode ? 'OLUŞTUR' : 'İPTAL'}
            </IconButton>

            {createMode && (<CreateCategoryPanel setCreateMode={setCreateMode} />)}

            {
                error && (
                    <Message
                        showIcon
                        closable
                        className='mb-3'
                        type="error"
                        title="Bir hata oluştu"
                        description={error.message}/>
                )
            }

            {
                categories &&
                categories.map(category =>
                    <CategoryPanel key={category.id} category={category} />
                )
            }

            {
                (categories &&
                categories.length === 0 &&
                !createMode) && (
                    <Message
                        showIcon
                        type="info"
                        title=""
                        description={
                            <>
                                <p>Gösterilecek hiç kategori yok</p>
                                <span>Yeni bir kategori</span>
                                <Button appearance='link' color='cyan' onClick={toggleCreateMode}>oluştur</Button>
                            </>}
                    />
                )
            }

            {pending && (<Loader backdrop content="loading..." vertical />)}
        </div>
    )
}

export default CategoryList;