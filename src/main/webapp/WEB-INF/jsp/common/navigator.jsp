<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <div class="hotProductCategory">

        <c:forEach items="${categories}" var="category">
            <dl>
                <dt>
                    <a href="./蔬菜分类.htm">${category.cname}</a>
                </dt>
                <c:forEach items="${category.categorysecondSet}" var="categorysecond">
                    <dd>
                        <a >${categorysecond.csname}</a>
                    </dd>
                </c:forEach>

            </dl>
        </c:forEach>

    </div>
</div>

