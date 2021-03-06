USE [MiniMartSoftWare]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 11/25/2019 1:19:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[OrderID] [varchar](30) NOT NULL,
	[CustomerPhone] [varchar](10) NOT NULL,
	[UserID] [varchar](20) NULL,
 CONSTRAINT [PK_Bill] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BillDetail]    Script Date: 11/25/2019 1:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillDetail](
	[OrderID] [varchar](30) NULL,
	[ProductID] [varchar](20) NULL,
	[ProductName] [varchar](50) NULL,
	[CategoryID] [varchar](20) NULL,
	[Price] [int] NULL,
	[Quantity] [int] NULL,
	[OrderDate] [date] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 11/25/2019 1:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryID] [varchar](20) NOT NULL,
	[CategoryName] [varchar](50) NULL,
	[Description] [varchar](50) NULL,
	[Available] [bit] NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 11/25/2019 1:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[Phone] [varchar](10) NOT NULL,
	[CustomerName] [varchar](50) NULL,
	[Address] [varchar](50) NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[Phone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employees]    Script Date: 11/25/2019 1:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employees](
	[UserID] [varchar](20) NOT NULL,
	[PassWord] [varchar](50) NOT NULL,
	[FullName] [varchar](50) NULL,
	[Gender] [varchar](10) NULL,
	[Address] [varchar](50) NULL,
	[Phone] [varchar](10) NULL,
	[Role] [varchar](20) NULL,
	[Note] [varchar](50) NULL,
	[Available] [bit] NULL,
 CONSTRAINT [PK_Employees] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 11/25/2019 1:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductID] [varchar](20) NOT NULL,
	[ProductName] [varchar](50) NOT NULL,
	[CategoryID] [varchar](20) NOT NULL,
	[UnitPrice] [int] NOT NULL,
	[Packaging] [varchar](50) NOT NULL,
	[Description] [varchar](50) NULL,
	[Available] [bit] NOT NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Bill] ([OrderID], [CustomerPhone], [UserID]) VALUES (N'DA_241119082132', N'0344571875', N'user1')
INSERT [dbo].[Bill] ([OrderID], [CustomerPhone], [UserID]) VALUES (N'DA_241119090841', N'0569441221', N'user1')
INSERT [dbo].[Bill] ([OrderID], [CustomerPhone], [UserID]) VALUES (N'DA_241119094023', N'0344571875', N'user1')
INSERT [dbo].[Bill] ([OrderID], [CustomerPhone], [UserID]) VALUES (N'DA_251119105222', N'0123456789', N'user2')
INSERT [dbo].[Bill] ([OrderID], [CustomerPhone], [UserID]) VALUES (N'DA_251119111041', N'0344571875', N'user2')
INSERT [dbo].[Bill] ([OrderID], [CustomerPhone], [UserID]) VALUES (N'DA_251119112717', N'0344571875', N'user1')
INSERT [dbo].[BillDetail] ([OrderID], [ProductID], [ProductName], [CategoryID], [Price], [Quantity], [OrderDate]) VALUES (N'DA_241119082132', N'thm1', N'TH TRUE MILK1', N'SNF', 2000, 1, CAST(N'2019-11-24' AS Date))
INSERT [dbo].[BillDetail] ([OrderID], [ProductID], [ProductName], [CategoryID], [Price], [Quantity], [OrderDate]) VALUES (N'DA_241119082132', N'thm1', N'TH TRUE MILK1', N'SNF', 2000, 2, CAST(N'2019-11-24' AS Date))
INSERT [dbo].[BillDetail] ([OrderID], [ProductID], [ProductName], [CategoryID], [Price], [Quantity], [OrderDate]) VALUES (N'DA_241119082132', N'thm', N'TH TRUE MILK', N'MI', 1000, 3, CAST(N'2019-11-24' AS Date))
INSERT [dbo].[BillDetail] ([OrderID], [ProductID], [ProductName], [CategoryID], [Price], [Quantity], [OrderDate]) VALUES (N'DA_241119090841', N'thm1', N'TH TRUE MILK1', N'SNF', 2000, 3, CAST(N'2019-11-24' AS Date))
INSERT [dbo].[BillDetail] ([OrderID], [ProductID], [ProductName], [CategoryID], [Price], [Quantity], [OrderDate]) VALUES (N'DA_251119111041', N'thm1', N'TH TRUE MILK1', N'MI', 3000, 4, CAST(N'2019-11-25' AS Date))
INSERT [dbo].[BillDetail] ([OrderID], [ProductID], [ProductName], [CategoryID], [Price], [Quantity], [OrderDate]) VALUES (N'DA_251119111041', N'thm1', N'TH TRUE MILK1', N'MI', 3000, 4, CAST(N'2019-11-25' AS Date))
INSERT [dbo].[BillDetail] ([OrderID], [ProductID], [ProductName], [CategoryID], [Price], [Quantity], [OrderDate]) VALUES (N'DA_251119112717', N'thm5', N'TH TRUE MILK 5', N'CD', 123456, 12, CAST(N'2019-11-25' AS Date))
INSERT [dbo].[BillDetail] ([OrderID], [ProductID], [ProductName], [CategoryID], [Price], [Quantity], [OrderDate]) VALUES (N'DA_241119082132', N'thm4', N'TH TRUE MILK4', N'MI', 5000, 5, CAST(N'2019-11-24' AS Date))
INSERT [dbo].[BillDetail] ([OrderID], [ProductID], [ProductName], [CategoryID], [Price], [Quantity], [OrderDate]) VALUES (N'DA_241119094023', N'thm1', N'TH TRUE MILK1', N'SNF', 2000, 333, CAST(N'2019-11-24' AS Date))
INSERT [dbo].[BillDetail] ([OrderID], [ProductID], [ProductName], [CategoryID], [Price], [Quantity], [OrderDate]) VALUES (N'DA_251119105222', N'thm1', N'TH TRUE MILK1', N'MI', 3000, 2, CAST(N'2019-11-25' AS Date))
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [Description], [Available]) VALUES (N'1', N'3323423', N'', 1)
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [Description], [Available]) VALUES (N'CD', N'Candy', NULL, 1)
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [Description], [Available]) VALUES (N'MI', N'Milk.', N'', 1)
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [Description], [Available]) VALUES (N'PP', N'Paper', N'', 1)
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [Description], [Available]) VALUES (N'SNF', N'Snack food', N'', 1)
INSERT [dbo].[Customer] ([Phone], [CustomerName], [Address]) VALUES (N'0123456789', N'DA', N'HN')
INSERT [dbo].[Customer] ([Phone], [CustomerName], [Address]) VALUES (N'0344571875', N'Nguyen Duy Anh', N'HCM')
INSERT [dbo].[Customer] ([Phone], [CustomerName], [Address]) VALUES (N'0569441221', N'Duy Anh', N'Tan Phu')
INSERT [dbo].[Employees] ([UserID], [PassWord], [FullName], [Gender], [Address], [Phone], [Role], [Note], [Available]) VALUES (N'1', N'1', N'1', N'male', N'1', N'1234567890', N'1', N'1', 1)
INSERT [dbo].[Employees] ([UserID], [PassWord], [FullName], [Gender], [Address], [Phone], [Role], [Note], [Available]) VALUES (N'anhndse130595', N'1803', N'Nguyen Duy Anh', N'Male', N'Tan Phu', N'0344571875', N'admin', NULL, 1)
INSERT [dbo].[Employees] ([UserID], [PassWord], [FullName], [Gender], [Address], [Phone], [Role], [Note], [Available]) VALUES (N'user1', N'1', N'user1', N'Female', N'aed', N'0906352971', N'staff', N'', 1)
INSERT [dbo].[Employees] ([UserID], [PassWord], [FullName], [Gender], [Address], [Phone], [Role], [Note], [Available]) VALUES (N'user2', N'1', N'user2', N'Male', N'HCM', N'0569441221', N'staff', N'2', 1)
INSERT [dbo].[Employees] ([UserID], [PassWord], [FullName], [Gender], [Address], [Phone], [Role], [Note], [Available]) VALUES (N'user3', N'1', N'Duy Anh', N'Female', N'HCM', N'0344571875', N'abc', N'3', 1)
INSERT [dbo].[Employees] ([UserID], [PassWord], [FullName], [Gender], [Address], [Phone], [Role], [Note], [Available]) VALUES (N'user4', N'1', N'A', N'Male', N'A', N'0909991234', N'A', N'A', 1)
INSERT [dbo].[Product] ([ProductID], [ProductName], [CategoryID], [UnitPrice], [Packaging], [Description], [Available]) VALUES (N'1', N'1', N'CD', 1, N'1', N'1', 0)
INSERT [dbo].[Product] ([ProductID], [ProductName], [CategoryID], [UnitPrice], [Packaging], [Description], [Available]) VALUES (N'THM', N'TH TRUE MILK', N'MI', 1000, N'HCM', N'A', 1)
INSERT [dbo].[Product] ([ProductID], [ProductName], [CategoryID], [UnitPrice], [Packaging], [Description], [Available]) VALUES (N'THM1', N'TH TRUE MILK1', N'MI', 3000, N'HN', N'B', 1)
INSERT [dbo].[Product] ([ProductID], [ProductName], [CategoryID], [UnitPrice], [Packaging], [Description], [Available]) VALUES (N'THM2', N'TH TRUE MILK2', N'CD', 3000, N'HCM', N'C', 1)
INSERT [dbo].[Product] ([ProductID], [ProductName], [CategoryID], [UnitPrice], [Packaging], [Description], [Available]) VALUES (N'THM3', N'TH TRUE MILK3', N'MI', 4000, N'HCM', N'D', 1)
INSERT [dbo].[Product] ([ProductID], [ProductName], [CategoryID], [UnitPrice], [Packaging], [Description], [Available]) VALUES (N'THM4', N'TH TRUE MILK4', N'SNF', 5000, N'HCM', N'E', 1)
INSERT [dbo].[Product] ([ProductID], [ProductName], [CategoryID], [UnitPrice], [Packaging], [Description], [Available]) VALUES (N'THM5', N'TH TRUE MILK 5', N'CD', 123456, N'HCM', N'F', 0)
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD  CONSTRAINT [FK_Bill_Customer] FOREIGN KEY([CustomerPhone])
REFERENCES [dbo].[Customer] ([Phone])
GO
ALTER TABLE [dbo].[Bill] CHECK CONSTRAINT [FK_Bill_Customer]
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD  CONSTRAINT [FK_Bill_Employees] FOREIGN KEY([UserID])
REFERENCES [dbo].[Employees] ([UserID])
GO
ALTER TABLE [dbo].[Bill] CHECK CONSTRAINT [FK_Bill_Employees]
GO
ALTER TABLE [dbo].[BillDetail]  WITH CHECK ADD  CONSTRAINT [FK_BillDetail_Bill] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Bill] ([OrderID])
GO
ALTER TABLE [dbo].[BillDetail] CHECK CONSTRAINT [FK_BillDetail_Bill]
GO
ALTER TABLE [dbo].[BillDetail]  WITH CHECK ADD  CONSTRAINT [FK_BillDetail_Product] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
GO
ALTER TABLE [dbo].[BillDetail] CHECK CONSTRAINT [FK_BillDetail_Product]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Category] ([CategoryID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
