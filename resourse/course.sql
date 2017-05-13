use netcourse;
-- Java程序设计
insert into tb_course values(101001,'Java程序设计','t1001','image\courseLogo\java.jpg','我们的生活已经离不开计算机了，每天都在用计算机上的软件做事情，这些软件究竟是如何写出来的呢？计算机到底是以怎样的方式来解决问题的呢？程序设计这门课可以让你学习到计算机解决问题的基本方法。 本课程是面向计算机新人的程序设计入门课程，Java语言是教学的媒介，但不是课程的目标。',
'程序设计是一门基础课程。对于计算机相关专业而言，程序设计是专业基础知识，是进一步学习其他专业知识的第一步阶梯；对于非计算机专业而言，程序设计的学习有助于理解计算机的能力所在，理解哪些是计算机擅长解决的问题，怎样的方式方法是计算机擅长的手段，从而能更好地利用计算机来解决本专业领域内的问题。
Java是近10年来最流行的编程语言，在各类编程语言排行榜上长年占据前两名的位置。
本课程是以Java语言来讲授程序设计的入门知识，而非具体教授Java语言，关于Java语言的全面知识，还需要学习本课程的后续课程——“Java语言程序设计进阶”。
程序设计是实践性很强的课程，该课程的学习有其自身的特点，听不会，也看不会，只能练会。你必须通过大量的编程训练，在实践中掌握编程知识，培养编程能力，并逐步理解和掌握程序设计的思想和方法。在这里所提供的，只是基础的知识讲解，要想学会编程，还需要更多时间的投入和努力。
为了学习编程，你需要有一台计算机，安装必要的编程软件。无论是MS Windows、Mac OS X还是Linux，都有适合Java语言编程的软件。
这门课的后续课程，是《Java程序设计进阶》');

-- C语言程序设计
insert into tb_course values(101002,'C语言程序设计','t1002','image\courseLogo\c语言.png',
'我们的生活已经离不开计算机了，每天都在用计算机上的软件做事情，这些软件究竟是如何写出来的呢？计算机到底是以怎样的方式来解决问题的呢？程序设计这门课可以让你学习到计算机解决问题的基本方法。 C语言是古老而长青的编程语言，它的语法是很多其他编程语言的基础，是我们这门课的教学语言。',
'程序设计是一门基础课程。对于计算机相关专业而言，程序设计是专业基础知识，是进一步学习其他专业知识的第一步阶梯；对于非计算机专业而言，程序设计的学习有助于理解计算机的能力所在，理解哪些是计算机擅长解决的问题，怎样的方式方法是计算机擅长的手段，从而能更好地利用计算机来解决本专业领域内的问题。
C语言是古老而长青的编程语言，它具备了现代程序设计的基础要求，它的语法是很多其他编程语言的基础，在系统程序、嵌入式系统等领域依然是无可替代的编程语言，在各类编程语言排行榜上常年占据前两名的位置。
对于非计算机专业的学生，学习本课程的主要目的是掌握程序设计的基本方法，C语言是教学媒介。但是对于计算机专业的学生，本课程是向后续的计算机组成、操作系统、编译原理、体系结构等课程前进的基石。
本课程是以C语言来讲授程序设计的入门知识，而非具体教授C语言，关于C语言的全面知识，还需要学习本课程的后续课程——“C语言程序设计进阶”。
程序设计是实践性很强的课程，该课程的学习有其自身的特点，听不会，也看不会，只能练会。你必须通过大量的编程训练，在实践中掌握编程知识，培养编程能力，并逐步理解和掌握程序设计的思想和方法。在这里所提供的，只是基础的知识讲解，要想学会编程，还需要更多时间的投入和努力。
为了学习编程，你需要有一台计算机，安装必要的编程软件。无论是MS Windows、Mac OS X还是Linux，都有适合C语言编程的软件。
本课程的后续课程是《C语言程序设计进阶》');

-- Python程序设计
insert into tb_course values(101003,'Python程序设计','t1003','image\courseLogo\Python语言编程基础.png',
'程序设计入门—Python”课程面向无编程基础的学生，培养运用 Python 编程语言解决实际问题的编程能力。使学生掌握 Python 语言的基本语法、语句以及结构化程序设计的基本思想和方法，了解基本的算法和数据结构，培养良好的程序设计风格，为进一步学习其他专业课程和从事软件开发工作打下坚实的基础。',
'过去近二十年的“高级语言程序设计”课程多是以 C 语言为主要的讲授对象，C 语言具有代码简洁紧凑、执行效率高、贴近硬件、可移植性好等优点，广泛应用于系统软件、嵌入式软件等开发。

    然而，随着计算机技术的发展和进步，我们可以使用它来解决越来越多的问题，计算机的应用场合也不局限于计算机学科，众多的学科被冠以“计算”之名，如计算生物学、计算化学等等。在这种情况下，C 语言这种“低级”语言已经越来越难适应计算机发展的潮流，众多的“高级”语言被创造出来以解决更实际的问题。

    另外，C 语言由于其语法过于灵活，所需要掌握的细节概念非常庞杂，即使是实现最简单的功能，也要涉及很多概念。因此如果教师在教学中不能将学生从语法细节中摆脱出来的话，那么往往也会吓退很多初学者，不利于学习兴趣的培养。

    最后就是尽管 C 语言对于学生掌握计算机底层的工作原理非常重要，但 C 语言相对比较“低级”，缺乏高级数据结构，因此要想解决更实际的问题，如字符串的处理、大规模的数据分析等，就需要编写非常大规模且复杂的代码，初学者往往会显得力不从心了。

    因此，我们需要一种简单易学且能解决更实际问题的语言，Python 语言恰好能弥补 C 语言的不足。

    本课程除了讲授 Python 语言程序设计语言的基本要素，包括基本数据类型、运算、控制结构、函数外，还讲授数据结构的概念和应用、算法时空复杂性的概念等知识，使学生在学完本课程后，即可利用计算机解决众多的实际问题。');

-- 高等数学
insert into tb_course values(101004,'高等数学','t1004','image\courseLogo\Python语言编程基础.png',
'伦琴在回答科学家需要怎样修养时说： 第一是数学 第二是数学 第三还是数学',
'本课程内容包含一元微分学，对应课本共三章内容：
第一章、极限与连续，共八节，即八讲；
第二章、导数与微分，共五节，即五讲；
第三章、微分中值定理，共三节，即三讲.');

-- C++程序设计
insert into tb_course values(101005,'C++程序设计 ','t1005','image\courseLogo\C++.jpg',
'本课程在C语言的基础上，讲解C++中的面向对象特性，通过动手编写程序引导各位初学者掌握他们，并且达到初步使用C++编写面向对象程序的目标。本课程蓝本为双语课，所以课件中会出现英文。不过重要的英文都有对应的中文译文，而且实验以及授课为中文，所以不必忧心英文问题。',
' 本课程讲什么？讲C++程序设计（后面一小段文字你可以略过，因为没学之前，看了也不懂，学了之后，不看也懂）。包括：对象、类、构造/析构函数、运算符重载、继承、虚函数与多态等。

    学完本课程能让你做什么？简单说，就是让你有了成为码农的基础（只学这门课，你距离码农这个高大上的职业还有很远的距离——从天顶星到地球的距离）。复杂点儿说，本课程培养学生阅读和编写C++程序的能力，通过课堂讲授和上机实验练习相结合的方法，使学生能独立完成基础的C++面向对象程序的开发。

    本课程有啥特色？打肿脸充胖子，特色是“边学边做，基于图形界面的实验”。其实真特色只能说是后边一半。您看哪门程序设计课不是“边学边做”？可是“基于图形界面的实验”要多学一门图形库的函数，要比非图形界面的实验难那么一点点。');
    
  -- 数据结构
insert into tb_course values(101006,'数据结构 ','t1006','image\courseLogo\数据结构与算法.png',
'本课程在C语言的基础上，讲解C++中的面向对象特性，通过动手编写程序引导各位初学者掌握他们，并且达到初步使用C++编写面向对象程序的目标。本课程蓝本为双语课，所以课件中会出现英文。不过重要的英文都有对应的中文译文，而且实验以及授课为中文，所以不必忧心英文问题。',
' 本课程讲什么？讲C++程序设计（后面一小段文字你可以略过，因为没学之前，看了也不懂，学了之后，不看也懂）。包括：对象、类、构造/析构函数、运算符重载、继承、虚函数与多态等。

    学完本课程能让你做什么？简单说，就是让你有了成为码农的基础（只学这门课，你距离码农这个高大上的职业还有很远的距离——从天顶星到地球的距离）。复杂点儿说，本课程培养学生阅读和编写C++程序的能力，通过课堂讲授和上机实验练习相结合的方法，使学生能独立完成基础的C++面向对象程序的开发。

    本课程有啥特色？打肿脸充胖子，特色是“边学边做，基于图形界面的实验”。其实真特色只能说是后边一半。您看哪门程序设计课不是“边学边做”？可是“基于图形界面的实验”要多学一门图形库的函数，要比非图形界面的实验难那么一点点。');  
    
 -- C#程序设计
   insert into tb_course values(101007,'C#程序设计 ','t1007','image\courseLogo\数据结构与算法.png',
'如果你以前学过程序设计，但就是编不出一个像“背单词”、“2048”、“库存管理”这样的实用程序，那就请你加入到《C#程序设计》课程中来吧。在这里，你不仅可以学到面向对象的语言和思想，还会学到如何编写图形化的用户界面、文本处理、图形图像、网络访问、多媒体、数据库应用等各类应用程序。',
' C#是一种优秀的面向对象语言，它继承了C++和Java等语言的优点，并与现代软件工程相适应。C#语言利用.NET作为运行平台，使得它在Windows图形用户界面、Web应用、数据库等方面有强大的功能。C#在企业信息化的软件开发中已广泛应用，成为主流的程序设计语言。
本课程在介绍C#语言及面向对象的程序设计基本原理的基础上，使用Visual Studio作为程序设计工具，介绍各种常见的信息的处理方法，包括文本处理、图形绘制、图像处理、多媒体、网络信息获取、数据库应用等。
课程中除了理论知识外，更注重上机编程实践，应用程序的例子紧密结合日常的学习和工作，生动有趣，难度适中。
本课程的目标是：学习和掌握C#语言的原理和方法，以及C#在常见的各类信息的处理以及企业信息化的应用，掌握软件开发的过程、工具与规范方法。');  

-- 计算机组成原理
 insert into tb_course values(101008,'计算机组成原理 ','t1008','image\courseLogo\数据结构与算法.png',
'课程在以培养学生创新能力和解决实际问题的能力为主的思想指导下，形成了由理论课、实验课、计算机设计与实践构成的课程体系。使学生系统地理解计算机硬件系统的组织结构和工作原理，掌握计算机硬件系统的基本分析与设计方法，建立计算机系统的整体概念。',
'哈尔滨工业大学“计算机组成原理”课程是国家级精品课程，以国家级教学名师唐朔飞教授编写的“十二五”规划教材为基础，将教学课件、学习指导与习题解答、试题库等一系列辅助教学组成一体，深入贯彻“激发式”的教学方法，激发学生自主探索知识的积极性，使学生能自主地体会到“为什么用计算机→计算机能做什么→要有什么样的结构→结构如何细化为模块→实现模块需要解决的问题→如何解决”。

通过基本技能训练、对部件综合设计和系统整体设计三个层次的培养，使学生具备扎实的基础理论、很强的独立工作能力和敢于创新的精神。 
');  

-- 离散数学基础

 insert into tb_course values(101009,'离散数学基础 ','t1009','image\courseLogo\离散数学.png',
'离散数学研究离散量的结构及相互关系，在符号处理的通用层面上讨论满足构造性思维的通用结构，其研究对象是符号化、结构化与可构造的数学对象，相应采用符号化、结构化与可构造的思维方法，是计算机专业的核心课程。',
' 离散数学是计算机专业的核心基础课程。计算机只能处理离散结构的数据，连续的、复杂的应用结构只能通过适当的离散化，分解抽象出离散的计算模型，才能由计算机进行处理。离散数学是计算机科学技术与工程的理论基础，而且随着计算机科学技术的发展不断形成新的应用体系。学生通过离散数学的学习，能够在数学推理、组合分析、离散结构构造、算法设计以及应用与建模等方面形成基本的离散思维方法，提高抽象思维和逻辑推理能力。离散数学也是后续专业课程（数据结构、编译系统、操作系统、数据库原理、人工智能、计算机网络等）的数学基础。离散数学的应用体系十分广泛，例如数字逻辑理论、逻辑电路设计、程序正确性证明、信息编码理论以及大量的图的实际应用模型。
   离散数学课程的主要内容包括：数理逻辑、集合与关系代数、图论以及代数结构等。通过本课程的学习，学生应该熟练掌握有关集合、关系、图、树等离散结构的基本知识，掌握有关逻辑和证明的基本技巧和方法，理解并能初步运用离散结构进行问题建模和求解。
'); 

-- 软件工程
 insert into tb_course values(101010,'软件工程 ','t1009','image\courseLogo\软件工程.jpg',
'我们写的不仅仅是代码！本篇将带您实现一个C语言小项目，通过其演化来呈现无设计代码、模块化设计的代码、可复用的代码和回调函数等接口设计，以及可重入函数、线程安全等较深入的设计问题。您可以通过跟随模仿来训练工程化代码的编写能力，辨识代码的工程质量差异。',
' 课程概述：本课程分为三篇：C编码实践篇；OO分析与设计篇；过程与管理篇。C编码实践篇强化实践能力训练，从学生较为熟悉的编程训练入手，以范例演示基本编码规范、 No Design时的代码、经过基本Modularity (also called separation of concerns)设计的代码、writing code to make it reusable on future projects以及一些特殊的接口设计如callback函数和函数的可重入性（reentrant）及线程安全等较深入的设计问题；这是课程的第一部分C编码实践篇，重实践，形成对软件工程直观感性的认识。课程的第二部分OO分析与设计篇将OO分析与设计过程细化为可操作的步骤，包括用例建模、领域建模、对象交互建模和设计类图，由易到难逐渐涉入设计模式、软件体系结构等较深入的话题。课程的第三部分过程与管理篇才开始对软件生命周期、软件项目任务切分工作量评估、项目计划、项目管理、进度跟踪等涉及软件工程项目全局性的概念方法做一梳理。'); 

-- 编译原理
 insert into tb_course values(101011,'编译原理 ','t1010','image\courseLogo\编译原理.jpg',
'该课程主要讲授编译器设计与实现的主要理论和技术。主要内容包括词法分析、语法分析、语法树构造、语义分析、中间代码生成、代码优化、目标代码生成等主要内容。该课程主要面向计算机专业相关学生、对计算机感兴趣的学生、及相关技术的从业人员等。',
'编译原理是计算机科学中历史最悠久，也是最高度发展的学科之一。编译器的设计与实现集中体现了计算机科学中的最核心的思想和技术，并且和计算机科学的其他研究领域，如形式语言与自动机、算法、数据结构、程序设计语言、计算机体系结构、软件工程等都有非常重要的联系。

本课程主要讲授编译器设计与实现中的理论和技术。主要内容包括词法分析、语法分析、语法树构造、语义分析、中间代码生成、代码优化、目标代码生成等主要内容。编译原理最大的特点是强调理论和实践的结合，这也是本课程最强调的部分。在理论方面，我们将和你一起讨论丰富有趣的理论知识，包括正则表达式、有限状态自动机、形式文法、类型系统、数据流方程、不动点算法、格、闭包等；而且实践部分，我们将讨论如果选择合理的数据结构和高效的算法来实现这些理论，以及如何运用软件工程中的思想来处理编译器设计中所出现的种种复杂性。

该课程主要面向计算机专业相关学生、对计算机感兴趣的学生、及相关技术的从业人员等。对于相关专业的学生来说，学习好编译原理这门课，不但可以理解和掌握编译编译课程本身，而且对于其他相关课程的学习也会有很好的帮助。而对于计算机相关技术的从业人员，学习编译原理相关知识，不但可以深刻理解程序设计语言的设计和实现原理，而且在工作中往往要设计新的领域专用语言及其编译器，因此，这部分知识也是必须的。'); 

-- c操作系统
 insert into tb_course values(101012,'操作系统 ','t1010','image\courseLogo\编译原理.jpg',
'《操作系统》是计算机相关专业的一门重要的专业课，学习本课程旨在使学生全面地理解、掌握操作系统各部分的基本原理和实现技术；能深层次地使用和改造操作系统；具备设计和实现操作系统等大型系统软件的能力。课程注重和实际操作系统(Linux)结合，引导学生参与真实操作系统的相关实践和开发。',
'课程特色：
（1）本课程完全在真实操作系统为基础进行案例教学
本课程的基本内容：进程管理、内存管理、IO管理、文件系统都以实际操作系统为案例开展了教学，真正做到操作系统原理和操作系统编码实现的贯通。
（2）本课程将在真实操作系统为基础进行全面实践
本课程以可真实运行的Linux 0.11为基础对其中的系统启动、系统调用、进程追踪、内核级线程实现、信号量实现、内存共享管理、键盘驱动控制、proc文件系统等内容进行了全面实践，通过这些实践学习者将对操作系统内核有了全面而深刻的认识，将具备修改操作系统内核的能力。
受众：
所有计算机相关专业的大学本科学生和研究生，主要包括计算机科学与技术专业、软件工程专业、信息处理专业、自动化控制专业等。'); 

-- 计算机网络
 insert into tb_course values(101013,'计算机网络 ','t1011','image\courseLogo\编译原理.jpg',
'《计算机网络》系列课程主要讲授计算机网络的基本概念、基本原理、典型网络协议与典型网络技术等内容，使学生扎实地掌握计算机网络基础知识，熟悉基本组网技术与简单网络应用开发技术，建立网络化思维意识，具备网络应用能力。',
'《计算机网络》系列课程分为：《计算机网络之网尽其用》、《计算机网络之探赜索隐》和《计算机网络之危机四伏》。
《计算机网络之网尽其用》将让你快速了解、认识计算机网络，理解并掌握计算机网络与网络协议等基本概念、网络组成与网络体系结构，剖析你每天都在使用的网络应用的类型、运行原理以及应用层协议，帮助你理解绝大多数网络应用所采用的应用编程接口-套接字（Socket），学习并掌握Socket编程技术，具备开发简单网络应用的能力。
也许你希望快速认识计算机网络、理解网络应用、了解并掌握网络应用程序开发技术，更高效利用计算机网络，为进一步探究计算机网络的深层奥秘奠定基础，那么这门课程是你最佳选择！。'); 

-- 数据库系统原理
 insert into tb_course values(101014,'数据库系统原理 ','t1012','image\courseLogo\编译原理.jpg',
'现代信息社会离不开数据库，计算机应用绕不过数据库。如何开发数据库应用？数据库应用的系统支撑软件，即数据库管理系统（DBMS），它的内核原理是怎样的？本课程引领你走进数据库这个丰富多彩又应用广泛的IT领域。',
'数据库是现代信息社会的基石。几乎所有的计算机应用软件都构建于数据库系统之上。数据库原理是高校计算机专业的核心课程。'); 

-- 线性代数
 insert into tb_course values(101015,'线性代数','t1013','image\courseLogo\编译原理.jpg',
'线性代数是19世纪后期发展起来的数学分支，是一门基础理论课程。 本课程主要讨论有限维线性空间的线性理论与方法，具有较强的逻辑性、抽象性与广泛的实用性，尤其在计算机日益普及的今天，解大型线性方程组、求矩阵的特征值等已成为技术人员经常遇到的课题。 本课程所介绍的方法广泛地应用于各个学科。',
'本课程主要讨论有限维线性空间的线性理论与方法，具有较强的逻辑性、抽象性与广泛的实用性，尤其在计算机日益普及的今天，解大型线性方程组、求矩阵的特征值等已经成为技术人员经常遇到的课题。因此，本课程所介绍的方法广泛地应用于各个学科。

通过本课程的学习，使学习者获得应用科学中常用的矩阵方法，线性方程组、二次型等理论及其有关的基础知识，并具有熟练的矩阵运算能力和用矩阵方法解决一些实际问题的能力，从而为学习后继课程及进一步扩大数学知识面、提高数学素养奠定必要的基础。

为方便广大学习者，MOOC线性代数课程将更注重学习过程的引导和学习兴趣的培养，我们将传统意义的线性代数课程分成六个部分，共53讲。主要内容包括：行列式、矩阵、n维向量、线性方程组、相似对角形、二次型。内容以较小的颗粒形式呈现，力求更突出其精华，一次讲解1-2个知识点，使学习者更易于接受，更感兴趣；同时穿插思考题或测试题，引导学习者设疑提问，共同学习与解决问题。'); 



-- 软件测试
 insert into tb_course values(101016,'软件测试','t1014','image\courseLogo\软件测试.jpg',
'从认识和理解软件Bug开始，介绍软件测试的基本理论，阐述软件测试设计的多样性原理。基于多样性原理，介绍白盒测试方法和黑盒测试，具体包括随机测试、等价类测试、控制流测试、数据流测试等；邀请业界专家讲解功能测试、性能测试、移动应用测试技术。',
'第1周：软件测试基础
本节主要熟悉课程系统，了解测试基本概念，重点理解Bug及其测试原理。

第2-3周：软件测试方法
本节主要讲解常用白盒测试方法与黑盒测试方法。白盒测试方法从程序员的角度看如何测试代码，并以JUnit为基础进行实践。黑盒测试方法从用户角度看进行系统测试，并以Selenium和PICT为基础进行实践。

第4-6周：软件测试实践
本节主要讲解功能测试、性能测试和移动应用测试。功能测试以微软记事本为例进行探索测试讲解，介绍华三的测试案例。性能测试以趋势、淘宝和华三为例进行讲解。移动应用测试以百度和趋势为例进行讲解。');

-- 面向对象软件开发实践之基本技能训练
 insert into tb_course values(101019,'计算机系统结构','t1016','image\courseLogo\计算机系统结构.jpg',
'计算机体系结构是计算机科学与技术、软件工程等专业的核心课程之一，重点论述计算机系统各种基本结构、设计技术和性能分析方法。通过本课程，了解计算机系统的各种基本结构，掌握在计算机设计各个环节中影响性能的因素，以及提高性能的各种理论和方法。',
'  本门课程属于计算机偏硬技术课程，针对计算机科学与技术、软件工程等专业高年级学生开设。主要讲授内容为：计算机系统结构、计算机指令集结构设计、流水线技术、指令级并行、存储层次结构、输入输出系统、多处理机等。
    采用分部分，逐步分析的方式进行课程的讲解，结合计算机系统性能提升的技术路线及方法分析计算机体系结构的基本理论、基本技术和基本方法，与此同时，采用最新计算机体系结构实例讲解课程内容。');


-- 软件安全
 insert into tb_course values(101021,'软件安全','t1017','image\courseLogo\软件安全.png',
'本课程是信息安全专业本科生高年级的一门系统性和实践性非常强的必修课程。主要内容由软件安全基础知识、恶意软件机理分析，以及恶意软件防护技术等组成。学习本课程有利于学生进一步理解各类恶意软件安全威胁的实现机理以及软件安全博弈对抗机制， 提升学生的实践创新能力。',
'本系列课程分为两门子课程，本课程为第一门子课程。
本课程将在软件安全基础知识（如磁盘结构与系统启动、PE文件结构、内存机制等）讲解的基础上，重点解析当前典型恶意软件（如PE病毒、网络木马、后门、Rootkit等）的功能、实现机制，以及对应的防护手段和技术。

为了促进同学们进一步体验软件安全领域的真实威胁，掌握课堂上学习的理论知识，增强基本的软件安全实践动手能力，在本MOOC课程开设期间，合天网安实验室将同步推出本课程配套的在线实验课程（MOOE），期待大家共同来体验。');

-- 信息安全
 insert into tb_course values(101022,'信息安全','t1017','image\courseLogo\信息安全.png',
'本课程介绍若干作为信息安全理论与技术的理论基础或重要工具的数学领域，对于信息安全专业的学生，有必要较为系统和深入的补充相关的数学知识，以便为进一步学习信息安全理论及技术奠定良好的数学基础。',
'本课程是哈尔滨工业大学计算机科学与技术学院信息安全专业本科生的专业基础课，旨在为信息安全专业的本科生补充必要的数学知识。课程内容主要包括三大部分：近世代数基础、数论基础及数理逻辑基础，这些内容都是信息安全专业必备而公共数学课较少涉及的，课程同时还注重与专业内容的衔接和过渡，着重介绍与信息安全专业相关的数学内容以及在信息安全专业中的应用，为后续学习“密码学”等课程打好基础。');


-- 近世代数
 insert into tb_course values(101023,'近世代数','t1018','image\courseLogo\近世代数.png',
'近世代数是研究各种代数结构的一门学科。其思想和方法已渗透到教学和科研工作的很多领域，成为包括计算机科学在内的很多学科中从事开发研究人员的基本工具。近世代数课程的内容包括：半群、幺半群、群、环、域、格、布尔代数等教学内容。',
'《近世代数》的研究在数学里是具有基本性的，他的方法和结果渗透到那些与它相近的各个不同的数学分支中。从而近世代数学就对全部数学的发展有着显著的影响。不但如此，近世代数学在其他一些科学领域也有较直接的应用。特别是在计算机科学领域，近世代数中的某些内容不但在计算机科学中有直接应用，而且还成为这个年轻学科的理论基础之一。
计算机科学是一个年轻的学科，许多问题还处在萌芽状态。有的处在由工程实践向理论转化的过程中，这就需要一个抽象的过程。同时对于未来的计算机工作者，就需要有较好的数学训练和抽象能力。近世代数这门课就分担着这样一项重要任务。');

